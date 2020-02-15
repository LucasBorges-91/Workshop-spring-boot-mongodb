package com.devlucas19.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devlucas19.workshopmongo.domain.UserEntity;

@RestController
@RequestMapping( value = "/users" )
public class UserResource {
	
	@RequestMapping( method=RequestMethod.GET )
	public ResponseEntity<List<UserEntity>> findAll() {
		   List<UserEntity> list = new ArrayList<>();
		   UserEntity maria = new UserEntity( "1001", "Maria Lourdes", "maria@gmail.com" );
		   UserEntity alex = new UserEntity("1002", "Alex Alves", "alex@gmail.com");
		   list.addAll(Arrays.asList(maria, alex));
		   return ResponseEntity.ok().body(list);
	}
}
