package com.intensivedata.makestories.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.intensivedata.makestories.model.Users;

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UsersRepository extends MongoRepository<Users, String> {

    Users findByUsername(@Param("username") String name);
    Users findByMobileno(@Param("mobileno") String mobileno);
    Users findByEmail(@Param("email") String email);
}
