package com.wipro.amazecare.service;

import com.wipro.amazecare.dto.ConsultationRequestDTO;
import com.wipro.amazecare.dto.ConsultationResponseDTO;

public interface ConsultationService {

    ConsultationResponseDTO createConsultation(Long doctorId, ConsultationRequestDTO dto);

    ConsultationResponseDTO getConsultationById(Long id);
}