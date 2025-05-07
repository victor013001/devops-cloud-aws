package com.pragma.challenge.devops_cloud_aws.infrastructure.exception.standard_exception;

import com.pragma.challenge.devops_cloud_aws.infrastructure.exception.StandardException;
import com.pragma.challenge.devops_cloud_aws.infrastructure.exception.util.Exceptions;
import org.springframework.http.HttpStatus;

public class UserNotFound extends StandardException {
  public UserNotFound() {
    super("E001", HttpStatus.NOT_FOUND, Exceptions.USER_NOT_FOUND);
  }
}
