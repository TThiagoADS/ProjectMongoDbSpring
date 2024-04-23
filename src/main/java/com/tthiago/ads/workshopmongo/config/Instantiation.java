package com.tthiago.ads.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.tthiago.ads.workshopmongo.domain.Post;
import com.tthiago.ads.workshopmongo.domain.User;
import com.tthiago.ads.workshopmongo.dto.AuthorDTO;
import com.tthiago.ads.workshopmongo.repository.PostRepository;
import com.tthiago.ads.workshopmongo.repository.UserRepository;


@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	UserRepository ur;
	
	@Autowired
	private PostRepository pr;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		ur.deleteAll();
		pr.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		ur.saveAll(Arrays.asList(maria,alex,bob));
		
		Post post1 = new Post(null,sdf.parse("21/03/2018"),"partiu viagem","to indo pra sp",new AuthorDTO(maria));
		Post post2 = new Post(null,sdf.parse("23/03/2018"),"acordei gay","gay", new AuthorDTO(maria));
		
		
		pr.saveAll(Arrays.asList(post1,post2));
		
		
		maria.getPosts().addAll(Arrays.asList(post1,post2));
		ur.save(maria);
	}

}
