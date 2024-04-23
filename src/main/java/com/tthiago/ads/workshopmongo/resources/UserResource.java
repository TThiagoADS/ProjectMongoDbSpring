package com.tthiago.ads.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tthiago.ads.workshopmongo.domain.User;
import com.tthiago.ads.workshopmongo.services.UserService;

@RestController //indica que é um controlador
@RequestMapping(value = "/users") //forma de dar nome ao metodo chamado no postman
public class UserResource {
	
	@Autowired
	private UserService service;
	
	
	@GetMapping //metodo usado no Postman
	public ResponseEntity <List<User>> findAll(){ //ResponseEntity é uma forma de manipular as respostas.
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
