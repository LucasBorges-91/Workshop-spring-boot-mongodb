package com.devlucas19.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devlucas19.workshopmongo.domain.UserEntity;
import com.devlucas19.workshopmongo.dto.UserDTO;
import com.devlucas19.workshopmongo.repository.UserRepository;
import com.devlucas19.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<UserEntity> findAll() {
		return repo.findAll();
	}
	
	public UserEntity findById( String id ) {
		Optional<UserEntity> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException( "Objeto não encontrado" ));
	}
	
	public UserEntity insert( UserEntity obj ) {
		return repo.insert(obj);
	}
	
	public void delete( String id ) {
		findById( id );
		repo.deleteById(id);
	}
	
	private void updateData(UserEntity newObj, UserEntity obj) {
		newObj.setName( obj.getName() );
		newObj.setEmail( obj.getEmail() );
	}
	
	public UserEntity update( UserEntity obj ) {
		UserEntity newObj = findById( obj.getId() );
		updateData( newObj, obj );
		return repo.save(newObj);
	}
	

	public UserEntity fromDTO( UserDTO objDTO ) {
		return new UserEntity( objDTO.getId(), objDTO.getName(), objDTO.getEmail() );
	}
	
	
	
}
