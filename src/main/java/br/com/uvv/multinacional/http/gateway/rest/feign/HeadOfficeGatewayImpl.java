package br.com.uvv.multinacional.http.gateway.rest.feign;

import org.springframework.stereotype.Service;

@Service
public class HeadOfficeGatewayImpl implements HeadOfficeGateway {

	private HeadOfficeFeignClient headOfficeFeignClient;
	
	@Override
	public String checkWithHeadOffice(final String cpf, final String productCode, final Long companyCode) {		
		//Utiliza a tecnologia do feign client da netflix pra fazer o requestia via rest
		return headOfficeFeignClient.checkWithHeadOffice(cpf, productCode, companyCode);
	}

	
	
}
