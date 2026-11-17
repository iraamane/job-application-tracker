package io.github.iraamane.backend.application;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateApplicationRequest {

    @NotBlank(message = "Company name is required")
    @Size(max = 150, message = "Company name must not exceed 150 characters")
    private String company;

    @NotBlank(message = "Job title is required")
    @Size(max = 150, message = "Job title must not exceed 150 characters")
    private String jobTitle;

    @NotNull(message = "Application date is required")
    private LocalDateTime date;

    @Size(max = 150, message = "Location must not exceed 150 characters")
    private String location;

    @Size(max = 2000, message = "Notes must not exceed 2000 characters")
    private String notes;
}