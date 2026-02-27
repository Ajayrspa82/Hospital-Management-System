package com.wipro.amazecare.service;

import com.wipro.amazecare.dto.*;
import java.util.List;

public interface PatientService {

    PatientResponseDTO createPatient(PatientCreateDTO dto);

    PatientResponseDTO getPatientById(Long id);

    List<PatientResponseDTO> getAllPatients();

    PatientResponseDTO updatePatient(Long id, PatientUpdateDTO dto);

    void deletePatient(Long id);

	PatientResponseDTO updatePatient(PatientUpdateDTO dto);
}