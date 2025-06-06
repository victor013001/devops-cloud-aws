package com.pragma.challenge.devops_cloud_aws.infrastructure.exception;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class StandardError {
  private String code;
  private LocalDateTime timestamp;
  private String description;

  @Override
  public String toString() {
    return "{"
        + "code='"
        + code
        + '\''
        + ", timestamp="
        + timestamp
        + ", description='"
        + description
        + '\''
        + '}';
  }
}
