package com.devlucas19.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devlucas19.workshopmongo.domain.UserEntity;
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
}
