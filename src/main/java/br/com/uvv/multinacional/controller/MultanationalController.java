package br.com.uvv.multinacional.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.uvv.multinacional.controller.json.CompanyJson;
import br.com.uvv.multinacional.domains.Client;
import br.com.uvv.multinacional.domains.Product;
import br.com.uvv.multinacional.usecase.BuyProductUseCase;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("${baseurl.v1}/multinational")
@Api(tags = "Multionational", produces = MediaType.APPLICATION_JSON_VALUE)
public class MultanationalController {
	
	@Autowired
	private BuyProductUseCase buyProductUseCase;
	
	@ApiOperation(value = "Resource to save stop production list")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 400, message = "Bad Request"),
			@ApiResponse(code = 401, message = "Unauthorized"),
			@ApiResponse(code = 422, message = "Unprocessable Entity"),
			@ApiResponse(code = 500, message = "Internal Server Error") })	
	@Validated
	@ResponseStatus(HttpStatus.OK) 
	@GetMapping("buy")
	public String buyProduct(final @RequestBody(required = true) CompanyJson companyJson) {
		//Chamada simples para UseCaseBuyProduct
//		return buyProductUseCase.buyProduct(client, product, companyCode);
		final Product product = new Product();
		
		product.setCode(companyJson.getProduct().getCode());
		product.setDescription(companyJson.getProduct().getDescription());

		final Client client = new Client();
		
		client.setCpf(companyJson.getClient().getCpf());
		client.setName(companyJson.getClient().getName());
		
		//Chamada simples para UseCaseBuyProduct
		return buyProductUseCase.buyProduct(client, product, companyJson.getCompanyCode());
	}
	
}
