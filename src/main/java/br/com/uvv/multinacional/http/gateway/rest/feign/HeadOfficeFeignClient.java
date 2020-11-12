package br.com.uvv.multinacional.http.gateway.rest.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.uvv.multinacional.domains.Client;
import br.com.uvv.multinacional.domains.Product;

@FeignClient
(name = "", path = "", url = "http://localhost:8080")
public interface HeadOfficeFeignClient {

	@GetMapping("")
	String checkWithHeadOffice(
			final @RequestBody(required = true) String cpf, 
			final @RequestBody(required = true) String productCode, 
			final @RequestBody(required = true) Long companyCode);
	
}
