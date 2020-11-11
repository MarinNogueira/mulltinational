package br.com.uvv.multinacional.http.gateway.rest.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.uvv.multinacional.domains.Client;
import br.com.uvv.multinacional.domains.Product;

@FeignClient
(name = "${feign.office.name}", path = "${feign.office.path}", url = "${feign.office.url}")
public interface HeadOfficeFeignClient {

	@GetMapping("")
	String checkWithHeadOffice(
			final @RequestBody(required = true) Client client, 
			final @RequestBody(required = true) Product product, 
			final @RequestBody(required = true) Long companyCode);
	
}
