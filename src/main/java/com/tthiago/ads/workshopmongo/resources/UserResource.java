package com.tthiago.ads.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tthiago.ads.workshopmongo.domain.User;

@RestController //indica que é um controlador
@RequestMapping(value = "/users") //forma de dar nome ao metodo chamado no postman
public class UserResource {
	
	
	
	@GetMapping //metodo usado no Postman
	public ResponseEntity <List<User>> findAll(){ //ResponseEntity é uma forma de manipular as respostas.
		User maria = new User("1", "maria brown", "maria@gmail.com");
		User alex = new User("2", "alex green", "alex@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria,alex));
		return ResponseEntity.ok().body(list);
	}

}
