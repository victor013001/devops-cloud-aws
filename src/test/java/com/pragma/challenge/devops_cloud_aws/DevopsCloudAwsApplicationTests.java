package com.pragma.challenge.devops_cloud_aws;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class DevopsCloudAwsApplicationTests {

	@Test
	void contextLoads() {
	}

}
