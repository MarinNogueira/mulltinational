package br.com.uvv.multinacional.http.gateway.database;

import java.util.ArrayList;
import java.util.List;

import br.com.uvv.multinacional.domains.Client;
import br.com.uvv.multinacional.domains.Company;
import br.com.uvv.multinacional.domains.Product;

public class DatabaseGatewayImpl implements DatabaseGateway {

	@Override
	public Boolean confirmClient(final String cpf, final String productCode, final Long companyCode) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private List<Company> loadCompany(){
		
		final List<Company> companyList = new ArrayList<>();
//		ooafdkodasfkfaofdkaofask
		
		createCompany(companyList, "000.000.000-00", "Larissa Randow", "0000", "Coraline Funko Pop");
		createCompany(companyList, "000.000.000-01", "Vitor Machado", "0001", "EVA-01");
		createCompany(companyList, "000.000.000-02", "Matheus Nogueira", "0002", "KDA Akali");
//		createCompany(companyList, "000.000.000-03", "Harry Potter", "0003", "Coraline Funko Pop");		
		
		return companyList;
	}

	private void createCompany(final List<Company> companyList, final String clientCpf, final String clientName, final String productCode, final String productDescription) {
		
		final Company company = new Company();
		
		company.setCompanyCode(1L);
		
		company.setClientList(new ArrayList<>());		

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
