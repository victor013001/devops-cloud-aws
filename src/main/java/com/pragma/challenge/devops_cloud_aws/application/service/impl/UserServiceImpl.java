package com.pragma.challenge.devops_cloud_aws.application.service.impl;

import com.pragma.challenge.devops_cloud_aws.application.mapper.UserMapper;
import com.pragma.challenge.devops_cloud_aws.application.service.UserService;
import com.pragma.challenge.devops_cloud_aws.infrastructure.dto.UserDto;
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

  private final UserRepository userRepository;
  private final UserMapper userMapper;

  @Override
  @Transactional
  public Mono<UserDto> createUser(UserDto userDto) {
    userRepository.findAll().log();
    return userRepository.save(userMapper.toUser(userDto)).map(userMapper::toUserDto);
  }

  @Override
  public Mono<UserDto> findUserByUuid(String uuid) {
    return userRepository.findByUuid(uuid).map(userMapper::toUserDto);
  }
}
