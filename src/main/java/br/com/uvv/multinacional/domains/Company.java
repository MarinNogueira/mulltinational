package br.com.uvv.multinacional.domains;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Company {
	private Long companyCode;
	private List<Product> productList;
	private List<Client> clientList;
	
}
