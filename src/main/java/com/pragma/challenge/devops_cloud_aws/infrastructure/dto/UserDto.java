package com.pragma.challenge.devops_cloud_aws.infrastructure.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserDto(
        @NotBlank(message = "Document Id is mandatory")
        String documentId,
        @NotBlank(message = "Name is mandatory")
        String name,
        @Email
        @NotBlank(message = "Email is mandatory")
        String email
) {
}
