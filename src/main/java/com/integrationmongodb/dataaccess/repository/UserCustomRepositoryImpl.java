package com.integrationmongodb.dataaccess.repository;

import com.integrationmongodb.dataaccess.schema.UserSchema;
import com.integrationmongodb.enums.ErrorCodeEnum;
import com.integrationmongodb.exception.UserSchemaNotContentException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;

public class UserCustomRepositoryImpl implements UserCustomRepositoryDetails {
 
  @Autowired
  MongoTemplate mongoTemplate;

  @Override
  public List<UserSchema> findAllCustomizer() {
    return mongoTemplate.findAll(UserSchema.class);
  }

  @Override
  public UserSchema findByIdCustomizer() {
    UserSchema userSchema =  mongoTemplate.findById("He46dafabb431a6ca7987aa2", UserSchema.class);
    if(userSchema == null) {
      throw new UserSchemaNotContentException(
          HttpStatus.NOT_ACCEPTABLE, 
          ErrorCodeEnum.NO_CONTENT_EXCEPTION.name(), //reson = errorcode ? errorCode : reason
          null, 
          ErrorCodeEnum.NO_CONTENT_EXCEPTION
       );
    }
    return userSchema;
  }
  

}
