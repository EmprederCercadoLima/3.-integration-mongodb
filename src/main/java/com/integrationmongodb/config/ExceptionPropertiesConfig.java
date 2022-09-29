package com.integrationmongodb.config;


import com.integrationmongodb.enums.ErrorCodeEnum;
import com.integrationmongodb.exception.ApiErrorException;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "application") 
@Getter
@Setter
public class ExceptionPropertiesConfig {
  private Map<ErrorCodeEnum, ApiErrorException> errors;
}
