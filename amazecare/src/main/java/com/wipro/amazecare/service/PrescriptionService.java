package com.wipro.amazecare.service;

import java.util.List;

import com.wipro.amazecare.dto.PrescriptionDTO;

public interface PrescriptionService {

    PrescriptionDTO addPrescription(Long consultationId, PrescriptionDTO dto);

    List<PrescriptionDTO> getPrescriptionsByConsultation(Long consultationId);
}