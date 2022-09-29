package com.integrationmongodb.business.impl;

import com.integrationmongodb.business.intf.UserInterface;
import com.integrationmongodb.dataaccess.repository.UserCustomRepositoryDetails;
import com.integrationmongodb.dataaccess.repository.UserCustomRepository;
import com.integrationmongodb.dataaccess.schema.UserSchema;

import java.util.List;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserImplement implements UserInterface {
  
  @Autowired
  @Qualifier("getUserCustomRepositoryImpl")
  private UserCustomRepositoryDetails userRepository; 

  @Override
  public List<UserSchema> findAllUsers() {
    return this.userRepository.findAllCustomizer();
  }

  @Override
  public UserSchema findById() {
    // TODO Auto-generated method stub
    return this.userRepository.findByIdCustomizer();
  }

}
