package br.com.uvv.multinacional.controller.json;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientJson {

	@ApiModelProperty(required = true)
	private String cpf;
	
	@ApiModelProperty(required = true)
	private String name;
	
}
