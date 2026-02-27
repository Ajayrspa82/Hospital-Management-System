package com.wipro.amazecare.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.amazecare.dto.ConsultationRequestDTO;
import com.wipro.amazecare.dto.ConsultationResponseDTO;
import com.wipro.amazecare.entity.Consultation;
import com.wipro.amazecare.entity.Doctor;
import com.wipro.amazecare.repository.ConsultationRepository;
import com.wipro.amazecare.repository.DoctorRepository;
import com.wipro.amazecare.service.ConsultationService;

@Service
public class ConsultationServiceImpl implements ConsultationService {

    @Autowired
    private ConsultationRepository consultationRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public ConsultationResponseDTO createConsultation(Long doctorId, ConsultationRequestDTO dto) {

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        Consultation consultation = new Consultation();
        consultation.setAppointmentId(dto.appointmentId);
        consultation.setSymptoms(dto.symptoms);
        consultation.setDiagnosis(dto.diagnosis);
        consultation.setTreatmentPlan(dto.treatmentPlan);
        consultation.setConsultationDate(dto.consultationDate);
        consultation.setDoctor(doctor);

        Consultation saved = consultationRepository.save(consultation);

        ConsultationResponseDTO response = new ConsultationResponseDTO();
        response.id = saved.getId();
        response.diagnosis = saved.getDiagnosis();
        response.doctorName = doctor.getName();

        return response;
    }

    @Override
    public ConsultationResponseDTO getConsultationById(Long id) {

        Consultation consultation = consultationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consultation not found"));

        ConsultationResponseDTO response = new ConsultationResponseDTO();
        response.id = consultation.getId();
        response.diagnosis = consultation.getDiagnosis();
        response.doctorName = consultation.getDoctor().getName();

        return response;
    }
}