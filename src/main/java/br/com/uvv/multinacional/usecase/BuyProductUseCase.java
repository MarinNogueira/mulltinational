package br.com.uvv.multinacional.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.uvv.multinacional.domains.Client;
import br.com.uvv.multinacional.domains.Product;
import br.com.uvv.multinacional.http.gateway.database.DatabaseGateway;
import br.com.uvv.multinacional.http.gateway.rest.feign.HeadOfficeGateway;

@Service
public class BuyProductUseCase {
	@Autowired
	private DatabaseGateway databaseGateway;
	@Autowired
	private HeadOfficeGateway headOfficeGateway;
	
	public String buyProduct(final Client client, final Product product, final Long companyCode) {
		
		//Código da companhia atual
		final Long thisCompanyCode = 1L;
		
		//Compara o código enviado com o código acima para se certificar que a multinacional tem acesso ao banco em que o cliente está cadastrado
		if(companyCode == thisCompanyCode && databaseGateway.confirmClient(client.getCpf(), product.getCode(), companyCode)) {
			//Retorna mensagem de sucesso caso as informações necessárias sejam validadas
			return "O cliente " + client.getName() + " de CPF: " + client.getCpf() + " concluiu a compra do produto " + product.getDescription() + " com sucesso";
			
		} else {
			//Chama o código da matriz para verificar se os dados existem no banco de dados 
			final String gatewayError = this.headOfficeGateway.checkWithHeadOffice(client.getCpf(), product.getCode(), companyCode);
			//O código da matriz retorna uma string vazia caso os dados sejam validados
			if(gatewayError.equals("")) {
				//Retorna mensagem de sucesso caso a string seja vazia
				return "O cliente " + client.getName() + " de CPF: " + client.getCpf() + " foi encontrado no banco de dados central. Compra do produto " + product.getDescription() + " concluida com sucesso";
			
			} else {
				//Retorna uma mensagem de erro caso venha o erro
				return gatewayError;
				
			}
			
		}
		
	}
	
}
