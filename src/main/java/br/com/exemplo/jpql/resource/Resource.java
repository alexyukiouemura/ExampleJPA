package br.com.exemplo.jpql.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.exemplo.jpql.resource.repository.ProdutoRepositoryImpl;

@RestController
public class Resource {
	
	@Autowired
	private ProdutoRepositoryImpl p;
	
	@GetMapping("/healthcheck")
	public String healthCheck() {
		return "OK";
	}
	
	@GetMapping("/teste")
	public String teste() {
		return p.list();
	}

}
