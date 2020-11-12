package br.com.uvv.multinacional.http.gateway.database;

public interface DatabaseGateway {

	Boolean confirmClient(final String cpf, final String productCode, final Long companyCode);
	
	
}
