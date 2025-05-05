package com.pragma.challenge.devops_cloud_aws.application.service;

import com.pragma.challenge.devops_cloud_aws.application.dto.UserDto;
import com.pragma.challenge.devops_cloud_aws.infrastructure.dto.UserRequest;
import reactor.core.publisher.Mono;

public interface UserService {
  Mono<UserDto> createUser(UserRequest userRequest);

  Mono<UserDto> findUserByUuid(String uuid);
}
