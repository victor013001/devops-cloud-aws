package com.pragma.challenge.devops_cloud_aws.application.mapper;

import com.pragma.challenge.devops_cloud_aws.domain.model.User;
import com.pragma.challenge.devops_cloud_aws.infrastructure.dto.UserDto;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

import java.util.Objects;
import java.util.UUID;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
  User toUser(UserDto userDto);

  UserDto toUserDto(User user);

  @AfterMapping
  default void setUuid(@MappingTarget User user) {
    if (Objects.isNull(user.getUuid())) {
      user.setUuid(UUID.randomUUID().toString());
    }
  }
}
