package com.tthiago.ads.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tthiago.ads.workshopmongo.domain.Post;
import com.tthiago.ads.workshopmongo.repository.PostRepository;
import com.tthiago.ads.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	
	@Autowired
	private PostRepository repo;
	
	
	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id); //optional é uma maneira de ligar com possiveis objetos nulos
		return obj.orElseThrow(() -> new ObjectNotFoundException("object not found"));
	}
	
	public List<Post> findByTitle(String text){
		return repo.findByTitle(text);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime()+24*60*60*1000);
		return repo.fullSearch(text, minDate, maxDate);
	}

}
