package com.wipro.amazecare.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.amazecare.dto.PrescriptionDTO;
import com.wipro.amazecare.entity.Consultation;
import com.wipro.amazecare.entity.Prescription;
import com.wipro.amazecare.repository.ConsultationRepository;
import com.wipro.amazecare.repository.PrescriptionRepository;
import com.wipro.amazecare.service.PrescriptionService;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @Autowired
    private ConsultationRepository consultationRepository;

    @Override
    public PrescriptionDTO addPrescription(Long consultationId, PrescriptionDTO dto) {

        Consultation consultation = consultationRepository.findById(consultationId)
                .orElseThrow(() -> new RuntimeException("Consultation not found"));

        Prescription prescription = new Prescription();
        prescription.setMedicineName(dto.medicineName);
        prescription.setDosage(dto.dosage);
        prescription.setDurationInDays(dto.durationInDays);
        prescription.setConsultation(consultation);

        prescriptionRepository.save(prescription);

        return dto;
    }

    @Override
    public List<PrescriptionDTO> getPrescriptionsByConsultation(Long consultationId) {

        return prescriptionRepository.findAll()
                .stream()
                .filter(p -> p.getConsultation().getId().equals(consultationId))
                .map(p -> {
                    PrescriptionDTO dto = new PrescriptionDTO();
                    dto.medicineName = p.getMedicineName();
                    dto.dosage = p.getDosage();
                    dto.durationInDays = p.getDurationInDays();
                    return dto;
                }).collect(Collectors.toList());
    }
}