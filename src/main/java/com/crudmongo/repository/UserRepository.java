package com.crudmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.crudmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository <User, String> {

}
