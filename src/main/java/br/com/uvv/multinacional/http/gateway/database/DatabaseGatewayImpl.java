package br.com.uvv.multinacional.http.gateway.database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.uvv.multinacional.domains.Client;
import br.com.uvv.multinacional.domains.Company;
import br.com.uvv.multinacional.domains.Product;

public class DatabaseGatewayImpl implements DatabaseGateway {

	@Override
	public Boolean confirmClient(final String cpf, final String productCode, final Long companyCode) {

		final List<Company> companyList = loadCompany();
		
		for (Company company : companyList) {
			if(company.getCompanyCode() == companyCode) {
			
				for (Client client : company.getClientList()) {
					
					for(Product product : company.getProductList()) {
						if(product.getCode().equals(productCode) && client.getCpf().equals(cpf)) {
							return true;
						}
					}
					
				}
				
			}
			
		}
		
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
		
		companyList.add(company);
	}

}
