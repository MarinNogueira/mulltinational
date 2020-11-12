package br.com.uvv.multinacional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import br.com.uvv.multinacional.http.gateway.rest.feign.HeadOfficeFeignClient;

@EnableFeignClients(basePackageClasses = {HeadOfficeFeignClient.class})
@SpringBootApplication
public class MultinacionalApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultinacionalApplication.class, args);
	}

}
