package com.devlucas19.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devlucas19.workshopmongo.domain.UserEntity;
import com.devlucas19.workshopmongo.services.UserService;

@RestController
@RequestMapping( value = "/users" )
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping( method=RequestMethod.GET )
	public ResponseEntity<List<UserEntity>> findAll() {
		   List<UserEntity> list = service.findAll();
		   return ResponseEntity.ok().body(list);
	}
}
