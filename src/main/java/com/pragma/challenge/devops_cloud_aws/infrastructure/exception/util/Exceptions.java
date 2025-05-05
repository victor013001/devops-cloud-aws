package com.pragma.challenge.devops_cloud_aws.infrastructure.exception.util;

public class Exceptions {
  public static final String USER_NOT_FOUND = "User not found";

  private Exceptions() throws InstantiationException {
    throw new InstantiationException("Exceptions class cannot be instantiated");
  }
}
