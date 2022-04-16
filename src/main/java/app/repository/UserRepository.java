package app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import app.domain.User;

@Repository
public interface UserRepository extends MongoRepository <User, String> {

}
