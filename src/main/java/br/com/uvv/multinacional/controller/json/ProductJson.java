package br.com.uvv.multinacional.controller.json;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductJson {
	
	@ApiModelProperty(required = true)
	private String code;
	
	@ApiModelProperty(required = true)
	private String description;
	
}
