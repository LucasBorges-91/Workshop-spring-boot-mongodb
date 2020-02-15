package com.devlucas19.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.devlucas19.workshopmongo.domain.UserEntity;

@Repository
public interface UserRepository extends MongoRepository<UserEntity, String> {
	
	
}
