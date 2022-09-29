package com.integrationmongodb.controller;

import com.integrationmongodb.business.intf.UserInterface;
import com.integrationmongodb.dataaccess.schema.UserSchema;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/integration-mongodb/v1")
public class UserController {
  
  @Autowired
  private UserInterface userInterface; 
  
  @GetMapping("/")
  public List<UserSchema> findAllUsers() {
    return this.userInterface.findAllUsers();
  }

  @GetMapping("/find-by-id")
  public UserSchema findById() {
    return this.userInterface.findById();
  }
  
}
