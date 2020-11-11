package br.com.uvv.multinacional.usecase;

import br.com.uvv.multinacional.domains.Client;
import br.com.uvv.multinacional.domains.Product;
import br.com.uvv.multinacional.http.gateway.database.DatabaseGateway;
import br.com.uvv.multinacional.http.gateway.rest.feign.HeadOfficeGateway;

public class BuyProductUseCase {
	
	private DatabaseGateway databaseGateway;
	
	private HeadOfficeGateway headOfficeGateway;
	
	public String buyProduct(final Client client, final Product product, final Long companyCode) {
		
		final Long thisCompanyCode = 1L;
		
		if(companyCode == thisCompanyCode && databaseGateway.confirmClient(client.getCpf(), product.getCode(), companyCode)) {
			
			return "O cliente " + client.getName() + " de CPF: " + client.getCpf() + " concluiu a compra do produto " + product.getDescription() + " com sucesso";
			
		} else {
			
			final String gatewayError = this.headOfficeGateway.checkWithHeadOffice(client, product, companyCode);
			
			if(gatewayError.equals("")) {
				
				return "O cliente " + client.getName() + " de CPF: " + client.getCpf() + " foi encontrado no banco de dados central. Compra do produto " + product.getDescription() + " concluida com sucesso";
			
			} else {
			
				return gatewayError;
				
			}
			
		}
		
	}
	
}
