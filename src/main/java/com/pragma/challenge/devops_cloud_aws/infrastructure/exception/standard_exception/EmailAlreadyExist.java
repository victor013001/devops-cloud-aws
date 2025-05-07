package com.pragma.challenge.devops_cloud_aws.infrastructure.exception.standard_exception;

import com.pragma.challenge.devops_cloud_aws.infrastructure.exception.StandardException;
import com.pragma.challenge.devops_cloud_aws.infrastructure.exception.util.Exceptions;
import org.springframework.http.HttpStatus;

public class EmailAlreadyExist extends StandardException {
  public EmailAlreadyExist() {
    super("E003", HttpStatus.BAD_REQUEST, Exceptions.DUPLICATE_KEY);
  }
}
