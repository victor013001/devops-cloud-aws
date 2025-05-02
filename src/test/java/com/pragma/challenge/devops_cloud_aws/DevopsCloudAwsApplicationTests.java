package com.pragma.challenge.devops_cloud_aws;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class DevopsCloudAwsApplicationTests {

  static MySQLContainer<?> container = TestcontainersConfiguration.mysqlContainer();

  @BeforeAll
  static void beforeAll() {
    container.start();
  }

  @AfterAll
  static void afterAll() {
    container.stop();
  }

  @DynamicPropertySource
  static void datasourceProps(DynamicPropertyRegistry registry) {
    registry.add(
        "spring.r2dbc.url",
        () ->
            String.format(
                "r2dbc:mysql://%s:%d/%s",
                container.getHost(), container.getFirstMappedPort(), container.getDatabaseName()));
    registry.add("spring.r2dbc.username", container::getUsername);
    registry.add("spring.r2dbc.password", container::getPassword);
    registry.add(
        "spring.flyway.url",
        () ->
            String.format(
                "jdbc:mysql://%s:%d/%s",
                container.getHost(), container.getFirstMappedPort(), container.getDatabaseName()));
    registry.add("spring.flyway.user", container::getUsername);
    registry.add("spring.flyway.password", container::getPassword);
  }

  @Test
  void contextLoads() {
    assertThat(container.isCreated()).isTrue();
  }
}
