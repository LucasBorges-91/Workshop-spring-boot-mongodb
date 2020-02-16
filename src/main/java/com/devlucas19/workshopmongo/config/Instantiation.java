package com.devlucas19.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.devlucas19.workshopmongo.domain.Post;
import com.devlucas19.workshopmongo.domain.UserEntity;
import com.devlucas19.workshopmongo.dto.AuthorDTO;
import com.devlucas19.workshopmongo.repository.PostRepository;
import com.devlucas19.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );
		sdf.setTimeZone( TimeZone.getTimeZone( "GMT" ) );
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		UserEntity maria = new UserEntity( null, "Maria Lourdes", "maria@gmail.com" );
		UserEntity alex = new UserEntity( null, "Alex Alves", "alex@gmail.com" );
		UserEntity bob = new UserEntity( null, "Bob Grey", "bob@gmail.com" );

		userRepository.saveAll( Arrays.asList( maria, alex, bob ) );
		
		Post post1 = new Post( null, sdf.parse( "21/03/2018" ), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria) );
		Post post2 = new Post( null, sdf.parse( "23/03/2018" ), "Bom dia!", "Acordei feliz hoje!", new AuthorDTO(maria) );
		
		postRepository.saveAll( Arrays.asList( post1, post2 ) );
		
	}

}
