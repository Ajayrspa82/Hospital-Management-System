package com.wipro.amazecare.service;

import java.util.List;

import com.wipro.amazecare.dto.MedicalTestDTO;

public interface MedicalTestService {

    MedicalTestDTO createTest(MedicalTestDTO dto);

    MedicalTestDTO getTestById(Long id);

    List<MedicalTestDTO> getAllTests();

    MedicalTestDTO updateTest(Long id, MedicalTestDTO dto);

    void deleteTest(Long id);
}