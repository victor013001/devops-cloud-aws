package com.pragma.challenge.devops_cloud_aws.infrastructure.controller;

import com.pragma.challenge.devops_cloud_aws.application.dto.UserDto;
import com.pragma.challenge.devops_cloud_aws.application.service.UserService;
import com.pragma.challenge.devops_cloud_aws.infrastructure.dto.UserRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {
  private static final String LOG_PREFIX = "[User_Controller_V1] >>> ";

  private final UserService userService;

  @GetMapping("/{uuid}")
  public Mono<UserDto> getUserByUuid(@Valid @PathVariable final String uuid) {
    log.info("{} Finding User with UUID {}", LOG_PREFIX, uuid);
    return userService.findUserByUuid(uuid);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<UserDto> createUser(@Valid @RequestBody final UserRequest userRequest) {
    log.info(
        "{} Creating User with Name {} and document Id {}",
        LOG_PREFIX,
        userRequest.name(),
        userRequest.documentId());
    return userService.createUser(userRequest);
  }
}
