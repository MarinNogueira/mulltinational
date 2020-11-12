package br.com.uvv.multinacional.http.gateway.rest.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.uvv.multinacional.domains.Client;
import br.com.uvv.multinacional.domains.Product;

@FeignClient
(name = "${feign.headoffice.name}", path = "${feign.headoffice.path}", url = "${feign.headoffice.url}")
public interface HeadOfficeFeignClient {

	@GetMapping()
	String checkWithHeadOffice(
			final @RequestParam(required = true) String cpf, 
			final @RequestParam(required = true) String productCode, 
			final @RequestParam(required = true) Long companyCode);
	
}
