package br.com.uvv.multinacional.http.gateway.rest.feign;

public interface HeadOfficeGateway {
	String checkWithHeadOffice(final String cpf, final String productCode, final Long companyCode);
}
