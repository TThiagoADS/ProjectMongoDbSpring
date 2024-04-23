package com.tthiago.ads.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tthiago.ads.workshopmongo.domain.User;
import com.tthiago.ads.workshopmongo.dto.userDTO;
import com.tthiago.ads.workshopmongo.repository.UserRepository;
import com.tthiago.ads.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id); //optional é uma maneira de ligar com possiveis objetos nulos
		return obj.orElseThrow(() -> new ObjectNotFoundException("object not found"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(User newObj, User obj) {
		newObj.setName(obj.getName());
		newObj.setEmail(obj.getEmail());
		
	}

	public User fromDTO(userDTO objDtop) {
		return new User(objDtop.getId(),objDtop.getName(),objDtop.getEmail());
	}

}
