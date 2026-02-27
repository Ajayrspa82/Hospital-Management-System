package com.wipro.amazecare.service;

import java.util.List;

import com.wipro.amazecare.dto.DoctorRequestDTO;
import com.wipro.amazecare.dto.DoctorResponseDTO;

public interface DoctorService {

    DoctorResponseDTO addDoctor(DoctorRequestDTO dto);

    DoctorResponseDTO updateDoctor(Long id, DoctorRequestDTO dto);

    void deleteDoctor(Long id);

    DoctorResponseDTO getDoctorById(Long id);

    List<DoctorResponseDTO> getAllDoctors();
}