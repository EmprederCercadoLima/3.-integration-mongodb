package com.integrationmongodb.config;

import com.integrationmongodb.enums.ErrorCodeEnum;
import com.integrationmongodb.exception.UserSchemaNotContentException;
import com.integrationmongodb.util.StringUtil;

import java.nio.file.AccessDeniedException;

import java.util.Objects;

import javax.security.sasl.AuthenticationException;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import pe.com.niubiz.core.constants.ErrorCategory;
import pe.com.niubiz.core.exception.BespinException;

@RestControllerAdvice
@Slf4j
public class ControllerAdviceErrorConfig {

  @Autowired
  private ExceptionPropertiesConfig exceptionPropertiesConfig;

  @ResponseBody
  @ExceptionHandler(value = UserSchemaNotContentException.class)
  public ResponseEntity<Object> handleException(UserSchemaNotContentException ex) {
    log.error(" 1 CUSTOM UserSchemaNotContentException => {} ", ex.isExternalErrorCode());
    String code = ex.isExternalErrorCode()
        ? ex.getReason()
        : exceptionPropertiesConfig.getErrors().get(ex.getErrorCode()).getCode();
    this.logCustomError(" 1 UserSchemaNotContentException", code);
    return ResponseEntity
        .status(ex.getStatus())
        .body(BespinException.builder().systemCode(code).build());
  }


  @ExceptionHandler(BespinException.class)
  public ResponseEntity<BespinException> exception(BespinException ex) {
    log.error(" 4 EXCEPTION - UNAUTHORIZED: ", ex);
    String code = Objects.isNull(ex.getCode())
        ? exceptionPropertiesConfig.getErrors().get(ErrorCodeEnum.SERVER_ERROR_EXCEPTION).getCode()
        : ex.getCode();
    
    this.logCustomError(" 4 EXCEPTION - UNAUTHORIZED", code);
    return ResponseEntity.status(this.fromCategoryToHttpStatus(ex.getCategory())).body(
        BespinException.builder().category(ex.getCategory()).systemCode(code).build());
  }

  private void logCustomError(String msg, String code) {
    log.error(
        StringUtil.replaceSpaces(msg.concat(" CODE => {}")),
        StringUtil.replaceSpaces("ERROR-".concat(code)));
  }
  
  private HttpStatus fromCategoryToHttpStatus(ErrorCategory errorCategory) {
    if (errorCategory == null) {
      return HttpStatus.INTERNAL_SERVER_ERROR;
    } else {
      return HttpStatus.valueOf(errorCategory.getHttpStatus());
    }
  }
  
}