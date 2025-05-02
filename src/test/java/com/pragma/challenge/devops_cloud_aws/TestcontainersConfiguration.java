package com.pragma.challenge.devops_cloud_aws;

import org.testcontainers.containers.MySQLContainer;

class TestcontainersConfiguration {

  static MySQLContainer<?> mysqlContainer() {
    return new MySQLContainer<>("mysql:8")
        .withDatabaseName("it_db")
        .withUsername("admin")
        .withPassword("admin");
  }
}
