package com.pragma.challenge.devops_cloud_aws.application.service;

import com.pragma.challenge.devops_cloud_aws.infrastructure.dto.UserDto;
import reactor.core.publisher.Mono;

public interface UserService {
    Mono<UserDto> createUser(UserDto userDto);
    Mono<UserDto> findUserByUuid(String uuid);
}
