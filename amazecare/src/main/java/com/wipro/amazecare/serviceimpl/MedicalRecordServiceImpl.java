package com.wipro.amazecare.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.amazecare.dto.MedicalRecordDTO;
import com.wipro.amazecare.entity.Consultation;
import com.wipro.amazecare.entity.MedicalRecord;
import com.wipro.amazecare.repository.ConsultationRepository;
import com.wipro.amazecare.repository.MedicalRecordRepository;
import com.wipro.amazecare.service.MedicalRecordService;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {

    @Autowired
    private MedicalRecordRepository medicalRecordRepository;

    @Autowired
    private ConsultationRepository consultationRepository;

    @Override
    public MedicalRecordDTO addMedicalRecord(MedicalRecordDTO dto) {

        Consultation consultation = consultationRepository.findById(dto.consultationId)
                .orElseThrow(() -> new RuntimeException("Consultation not found"));

        MedicalRecord record = new MedicalRecord();
        record.setConsultation(consultation);
        record.setRecordDetails(dto.recordDetails);

        medicalRecordRepository.save(record);

        return dto;
    }
}