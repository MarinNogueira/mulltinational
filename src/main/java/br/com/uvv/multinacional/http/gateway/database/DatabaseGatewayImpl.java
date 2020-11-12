package br.com.uvv.multinacional.http.gateway.database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.uvv.multinacional.domains.Client;
import br.com.uvv.multinacional.domains.Company;
import br.com.uvv.multinacional.domains.Product;

@Service
public class DatabaseGatewayImpl implements DatabaseGateway {

	@Override
	public Boolean confirmClient(final String cpf, final String productCode, final Long companyCode) {
		//Carrega a lista de companhias em memória
		final List<Company> companyList = loadCompany();
		
		for (Company company : companyList) {
			//Faz o laço na lista de companhia e compara a companhia encontrada com a companhia recebida
			if(company.getCompanyCode() == companyCode) {
			
				for (Client client : company.getClientList()) {
					
					for(Product product : company.getProductList()) {
						// faz o laço na lista de produto e cliente e caso os produtos e cliente enviado sejam confirmados pelos dados da base retorna verdadeiro
						if(product.getCode().equals(productCode) && client.getCpf().equals(cpf)) {
							return true;
						}
					}
					
				}
				
			}
			
		}
		//Caso nada seja encontrado retorna falso
		return false;
	}
	
	private List<Company> loadCompany(){
		
		final List<Company> companyList = new ArrayList<>();
		
		companyList.addAll(Arrays.asList(new Company(), new Company(), new Company()));
		
		companyList.get(0).setCompanyCode(0L);
		companyList.get(1).setCompanyCode(1L);
		companyList.get(2).setCompanyCode(2L);
		
		createCompany(companyList.get(0), "000.000.000-00", "Larissa Randow", "0000", "Coraline Funko Pop");
		createCompany(companyList.get(1), "000.000.000-01", "Vitor Machado", "0001", "EVA-01");
		createCompany(companyList.get(0), "000.000.000-02", "Matheus Nogueira", "0002", "KDA Akali");
		createCompany(companyList.get(2), "000.000.000-03", "Harry Potter", "0003", "Coraline Funko Pop");		
		
		return companyList;
	}

	private void createCompany(final Company company, final String clientCpf, final String clientName, final String productCode, final String productDescription) {		

		final Client client = new Client();
		
		client.setCpf(clientCpf);
		client.setName(clientName);
		
		company.getClientList().add(client);

		company.setProductList(new ArrayList<>());
		
		final Product product = new Product();
		
		product.setCode(productCode);
		product.setDescription(productDescription);
		
		company.getProductList().add(product);
		
	}

}
