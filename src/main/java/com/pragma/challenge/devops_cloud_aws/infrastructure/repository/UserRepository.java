package com.pragma.challenge.devops_cloud_aws.infrastructure.repository;

import com.pragma.challenge.devops_cloud_aws.domain.model.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User, Long> {
  Mono<User> findByUuid(String uuid);

  Mono<Boolean> existsByDocumentId(String documentId);

  Mono<Boolean> existsByEmail(String email);
}
