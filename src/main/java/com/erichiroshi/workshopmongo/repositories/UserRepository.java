package com.erichiroshi.workshopmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.erichiroshi.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
