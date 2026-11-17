package io.github.iraamane.backend.application;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApplicationMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "status", ignore = true)
    Application toEntity(CreateApplicationRequest request);

    ApplicationDto toDto(Application application);

}