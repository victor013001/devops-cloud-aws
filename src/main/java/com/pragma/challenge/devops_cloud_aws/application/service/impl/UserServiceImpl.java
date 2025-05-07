package com.pragma.challenge.devops_cloud_aws.application.service.impl;

import com.pragma.challenge.devops_cloud_aws.application.dto.UserDto;
import com.pragma.challenge.devops_cloud_aws.application.mapper.UserMapper;
import com.pragma.challenge.devops_cloud_aws.application.service.UserService;
import com.pragma.challenge.devops_cloud_aws.infrastructure.dto.UserRequest;
import com.pragma.challenge.devops_cloud_aws.infrastructure.exception.standard_exception.DocumentIdAlreadyExist;
import com.pragma.challenge.devops_cloud_aws.infrastructure.exception.standard_exception.EmailAlreadyExist;
import com.pragma.challenge.devops_cloud_aws.infrastructure.exception.standard_exception.UserNotFound;
import com.pragma.challenge.devops_cloud_aws.infrastructure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private static final String LOG_PREFIX = "[User_Default_Service] >>> ";

  private final UserRepository userRepository;
  private final UserMapper userMapper;

  @Override
  @Transactional
  public Mono<UserDto> createUser(UserRequest userRequest) {
    return checkDocumentIdUnique(userRequest.documentId())
        .then(checkEmailUnique(userRequest.email()))
        .then(userRepository.save(userMapper.toUser(userRequest)).map(userMapper::toUserDto));
  }

  @Override
  public Mono<UserDto> findUserByUuid(String uuid) {
    return userRepository
        .findByUuid(uuid)
        .switchIfEmpty(Mono.error(UserNotFound::new))
        .map(userMapper::toUserDto);
  }

  private Mono<Void> checkDocumentIdUnique(String documentId) {
    log.info("{} Checking if Document Id {} exists", LOG_PREFIX, documentId);
    return userRepository
        .existsByDocumentId(documentId)
        .flatMap(exist -> Boolean.TRUE.equals(exist) ? Mono.error(DocumentIdAlreadyExist::new) : Mono.empty());
  }

  private Mono<Void> checkEmailUnique(String email) {
    log.info("{} Checking if Email {} exists", LOG_PREFIX, email);
    return userRepository
        .existsByEmail(email)
        .flatMap(exist -> Boolean.TRUE.equals(exist) ? Mono.error(EmailAlreadyExist::new) : Mono.empty());
  }
}
