package com.integrationmongodb.dataaccess.repository;

import com.integrationmongodb.dataaccess.schema.UserSchema;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface UserCustomRepository extends MongoRepository<UserSchema, String>, UserCustomRepositoryDetails {
}
