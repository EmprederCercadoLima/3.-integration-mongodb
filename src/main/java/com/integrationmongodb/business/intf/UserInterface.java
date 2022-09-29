package com.integrationmongodb.business.intf;

import com.integrationmongodb.dataaccess.schema.UserSchema;

import java.util.List;

public interface UserInterface {
  
  List<UserSchema> findAllUsers();
  UserSchema findById();
}
