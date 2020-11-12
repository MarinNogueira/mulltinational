package br.com.uvv.multinacional.controller.json;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyJson {

	@ApiModelProperty(required = true)
	private Long companyCode;

	@ApiModelProperty(required = true)
	private ProductJson product;

	@ApiModelProperty(required = true)
	private ClientJson client;
}
