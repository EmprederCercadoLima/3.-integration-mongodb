package com.integrationmongodb.config;

import com.integrationmongodb.dataaccess.repository.UserCustomRepositoryImpl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MongoDBConfig {
  
  @Bean(name="getUserCustomRepositoryImpl")
  UserCustomRepositoryImpl getUserCustomRepositoryImpl(){
      return new UserCustomRepositoryImpl();
  }
 
}
