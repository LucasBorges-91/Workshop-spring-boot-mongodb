package com.devlucas19.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devlucas19.workshopmongo.domain.UserEntity;
import com.devlucas19.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<UserEntity> findAll() {
		return repo.findAll();
	}
}
