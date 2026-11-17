package io.github.iraamane.backend.application;


import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApplicationDto {

    private Long id;

    private String company;

    private String jobTitle;

    private LocalDateTime date;

    private String location;

    private ApplicationStatus status;

    private String notes;
}