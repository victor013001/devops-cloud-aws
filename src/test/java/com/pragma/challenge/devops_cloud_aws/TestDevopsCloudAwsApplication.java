package com.pragma.challenge.devops_cloud_aws;

import org.springframework.boot.SpringApplication;

public class TestDevopsCloudAwsApplication {

	public static void main(String[] args) {
		SpringApplication.from(DevopsCloudAwsApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
