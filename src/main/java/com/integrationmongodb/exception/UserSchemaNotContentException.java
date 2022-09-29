package com.integrationmongodb.exception;

import com.integrationmongodb.enums.ErrorCodeEnum;

import java.util.Date;

import lombok.Getter;

import org.springframework.core.NestedRuntimeException;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

@Getter
public class UserSchemaNotContentException extends NestedRuntimeException {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;
  
  private final HttpStatus status;

  private final String reason;
  
  private final ErrorCodeEnum errorCode;
  
  private final Date timeStamp = new Date();
  
  private final boolean isExternalErrorCode;

  public UserSchemaNotContentException(HttpStatus status,  @Nullable String reason, Throwable ex,
      ErrorCodeEnum errorCode) {
    super(reason, ex);
    Assert.notNull(status, "HttpStatus is required");
    Assert.notNull(reason, "Reason is required");
    this.status = status;
    this.reason = reason;
    this.errorCode = errorCode;
    this.isExternalErrorCode = !errorCode.name().equals(reason);
  }
  
}
