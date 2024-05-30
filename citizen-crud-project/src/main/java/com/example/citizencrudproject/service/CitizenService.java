package com.example.citizencrudproject.service;

import com.example.citizencrudproject.dto.CitizenDto;
import com.example.citizencrudproject.entity.Citizen;
import com.example.citizencrudproject.exception.UniqueUserException;
import com.example.citizencrudproject.mapper.CitizenMapper;
import com.example.citizencrudproject.repository.CitizenRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CitizenService {
    private final CitizenRepository citizenRepository;
    private final CitizenMapper citizenMapper;

    @Transactional(readOnly = true)
    public ResponseEntity<CitizenDto> getCitizenById(Long id){
        Citizen citizen = citizenRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        CitizenDto citizenDto = citizenMapper.ToDto(citizen);
        return ResponseEntity.ok(citizenDto);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<List<CitizenDto>> getAllCitizens(){
        List<Citizen> citizens = citizenRepository.findAll();

        if (citizens.isEmpty())
            throw  new EntityNotFoundException();

        List<CitizenDto> citizensDto = citizens.stream()
                .map(citizenMapper::ToDto)
                .toList();

        return ResponseEntity.ok(citizensDto);
    }

    @Transactional
    public ResponseEntity<Long> createCitizen(CitizenDto citizenDto) throws UniqueUserException {
        try{
            Citizen citizen = citizenMapper.ToEntity(citizenDto);
            Long citizenId = citizenRepository.save(citizen).getId();
            return ResponseEntity.ok(citizenId);
        }
        catch (Exception e){
            throw new UniqueUserException();
        }

    }

    @Transactional
    public ResponseEntity<Void> updateCitizen(Long id, CitizenDto citizenDto){
        citizenRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        Citizen citizen = citizenMapper.ToEntity(citizenDto);
        citizen.setId(id);
        citizenRepository.save(citizen);
        return ResponseEntity.ok().build();
    }

    @Transactional
    public ResponseEntity<Void> deleteCitizen(Long id){
        citizenRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        citizenRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
