package com.wipro.amazecare.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.amazecare.dto.DoctorSpecializationDTO;
import com.wipro.amazecare.entity.DoctorSpecialization;
import com.wipro.amazecare.repository.DoctorSpecializationRepository;
import com.wipro.amazecare.service.DoctorSpecializationService;

@Service
public class DoctorSpecializationServiceImpl implements DoctorSpecializationService {

    @Autowired
    private DoctorSpecializationRepository repository;

    @Override
    public DoctorSpecializationDTO addSpecialization(DoctorSpecializationDTO dto) {

        DoctorSpecialization specialization = new DoctorSpecialization();
        specialization.setName(dto.name);

        DoctorSpecialization saved = repository.save(specialization);

        DoctorSpecializationDTO response = new DoctorSpecializationDTO();
        response.id = saved.getId();
        response.name = saved.getName();

        return response;
    }

    @Override
    public List<DoctorSpecializationDTO> getAllSpecializations() {

        return repository.findAll()
                .stream()
                .map(s -> {
                    DoctorSpecializationDTO dto = new DoctorSpecializationDTO();
                    dto.id = s.getId();
                    dto.name = s.getName();
                    return dto;
                }).collect(Collectors.toList());
    }
}