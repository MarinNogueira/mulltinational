package br.com.uvv.multinacional.http.gateway.rest.feign;

import br.com.uvv.multinacional.domains.Client;
import br.com.uvv.multinacional.domains.Product;

public interface HeadOfficeGateway {
	String checkWithHeadOffice(final Client client, final Product product, final Long companyCode);
}
