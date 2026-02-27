package com.wipro.amazecare.service;

import com.wipro.amazecare.dto.MedicalRecordDTO;
import java.util.List;

public interface MedicalRecordService {

    MedicalRecordDTO createRecord(MedicalRecordDTO dto);

    MedicalRecordDTO getRecordById(Long id);

    List<MedicalRecordDTO> getRecordsByPatient(Long patientId);

    void deleteRecord(Long id);

	MedicalRecordDTO getById(Long id);

	List<MedicalRecordDTO> getAll();

	MedicalRecordDTO update(Long id, MedicalRecordDTO dto);

	void delete(Long id);
}