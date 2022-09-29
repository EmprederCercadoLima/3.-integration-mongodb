package com.integrationmongodb.exception;


import com.integrationmongodb.enums.ErrorCodeEnum;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ManagerException {
  private static final ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  
  public static UserSchemaNotContentException createException(ErrorCodeEnum errorCode, Throwable ex) {
    return new UserSchemaNotContentException(errorCode.getHttpStatus(),errorCode.name(), ex, errorCode);
  }
}
