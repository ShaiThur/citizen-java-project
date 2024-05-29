package com.example.citizencrudproject.mapper;

import com.example.citizencrudproject.dto.CitizenDto;
import com.example.citizencrudproject.entity.Citizen;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        injectionStrategy = InjectionStrategy.FIELD)
public interface CitizenMapper {
    Citizen ToEntity(CitizenDto citizen);
    CitizenDto ToDto(Citizen citizen);
}
