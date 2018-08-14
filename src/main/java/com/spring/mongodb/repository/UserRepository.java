package com.spring.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.mongodb.model.User;

public interface UserRepository extends MongoRepository<User, String> {

}
