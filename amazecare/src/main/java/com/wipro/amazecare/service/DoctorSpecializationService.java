package com.wipro.amazecare.service;

import java.util.List;

import com.wipro.amazecare.dto.DoctorSpecializationDTO;

public interface DoctorSpecializationService {

    DoctorSpecializationDTO addSpecialization(DoctorSpecializationDTO dto);

    List<DoctorSpecializationDTO> getAllSpecializations();
}