package com.integrationmongodb.dataaccess.repository;

import com.integrationmongodb.dataaccess.schema.UserSchema;

import java.util.List;

public interface UserCustomRepositoryDetails {
  List<UserSchema> findAllCustomizer();
  UserSchema findByIdCustomizer();
}
