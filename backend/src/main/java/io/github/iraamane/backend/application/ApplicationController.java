package io.github.iraamane.backend.application;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/applications")
public class ApplicationController {

    private final ApplicationService applicationService;
    @PostMapping
    public ResponseEntity<?> createApplication(
            @Valid @RequestBody CreateApplicationRequest request,
            UriComponentsBuilder uriBuilder) {

        var applicationDto = applicationService.createApplication(request);

        var uri = uriBuilder.path("/applications/{id}")
                .buildAndExpand(applicationDto.getId())
                .toUri();

        return ResponseEntity.created(uri).body(applicationDto);
    }

    @GetMapping
    public Iterable<ApplicationDto> getAllApplications(
            @RequestParam(required = false, defaultValue = "", name = "sort") String sortBy
    ){

        return applicationService.getAllApplications(sortBy);
    }
}
