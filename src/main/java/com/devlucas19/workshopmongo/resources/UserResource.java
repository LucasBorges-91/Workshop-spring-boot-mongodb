package com.devlucas19.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devlucas19.workshopmongo.domain.Post;
import com.devlucas19.workshopmongo.domain.UserEntity;
import com.devlucas19.workshopmongo.dto.UserDTO;
import com.devlucas19.workshopmongo.services.UserService;

@RestController
@RequestMapping( value = "/users" )
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@RequestMapping( method=RequestMethod.GET )
	public ResponseEntity<List<UserDTO>> findAll() {
		   List<UserEntity> list = service.findAll();
		   List<UserDTO> listDto = list.stream().map(obj -> new UserDTO (obj)).collect(Collectors.toList());
		   return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping( value="/{id}", method=RequestMethod.GET )
	public ResponseEntity <UserDTO> findById( @PathVariable String id ) {
		UserEntity obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO( obj ));
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity <Void> insert( @RequestBody UserDTO objDTO ) {
		UserEntity obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path( "/{id}").buildAndExpand( obj.getId() ).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping( value="/{id}", method=RequestMethod.DELETE )
	public ResponseEntity <Void> delete( @PathVariable String id ) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping( value="/{id}", method=RequestMethod.PUT )
	public ResponseEntity <Void> update( @RequestBody UserDTO objDto, @PathVariable String id ) {
		UserEntity obj = service.fromDTO( objDto );
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping( value="/{id}/posts", method=RequestMethod.GET )
	public ResponseEntity <List<Post>> findPosts( @PathVariable String id ) {
		UserEntity obj = service.findById(id);
		return ResponseEntity.ok().body( obj.getPosts() );
	}
	
}
