package io.github.iraamane.backend.application;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class ApplicationService {
    private final ApplicationRepository applicationRepository;
    private final ApplicationMapper applicationMapper;

    public ApplicationDto createApplication(CreateApplicationRequest request){

        var application = applicationMapper.toEntity(request);

        applicationRepository.save(application);

        return applicationMapper.toDto(application);
    }

    public Iterable<ApplicationDto> getAllApplications(String sortBy) {

        if (!Set.of("date", "company", "status").contains(sortBy))
            sortBy = "date";

        return applicationRepository.findAll(Sort.by(sortBy).descending())
                .stream()
                .map(applicationMapper::toDto)
                .toList();
    }

}
