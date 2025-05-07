package com.pragma.challenge.devops_cloud_aws.infrastructure.exception.util;

public class Exceptions {
  public static final String USER_NOT_FOUND = "User not found";
  public static final String SERVER_ERROR = "Server error";
  public static final String DUPLICATE_KEY = "Cannot process request with information provided";

  private Exceptions() throws InstantiationException {
    throw new InstantiationException("Exceptions class cannot be instantiated");
  }
}
