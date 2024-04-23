package com.tthiago.ads.workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tthiago.ads.workshopmongo.domain.User;
import com.tthiago.ads.workshopmongo.dto.userDTO;
import com.tthiago.ads.workshopmongo.services.UserService;

@RestController //indica que é um controlador
@RequestMapping(value = "/users") //forma de dar nome ao metodo chamado no postman
public class UserResource {
	
	@Autowired
	private UserService service;
	
	
	@GetMapping //metodo usado no Postman
	public ResponseEntity <List<userDTO>> findAll(){ //ResponseEntity é uma forma de manipular as respostas.
		List<User> list = service.findAll();
		List<userDTO> listDto = list.stream().map(x -> new userDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping (value="/{id}")
	public ResponseEntity <userDTO> findById(@PathVariable String id){ //anotação serve para que o id seja o mesmo passado como argumento
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new userDTO(obj)); 
	}

}
