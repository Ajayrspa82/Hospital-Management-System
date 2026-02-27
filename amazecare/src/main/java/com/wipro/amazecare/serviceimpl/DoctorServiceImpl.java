package com.wipro.amazecare.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.amazecare.dto.DoctorRequestDTO;
import com.wipro.amazecare.dto.DoctorResponseDTO;
import com.wipro.amazecare.entity.Doctor;
import com.wipro.amazecare.entity.DoctorSpecialization;
import com.wipro.amazecare.repository.DoctorRepository;
import com.wipro.amazecare.repository.DoctorSpecializationRepository;
import com.wipro.amazecare.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DoctorSpecializationRepository specializationRepository;

    @Override
    public DoctorResponseDTO addDoctor(DoctorRequestDTO dto) {

        DoctorSpecialization specialization = specializationRepository
                .findById(dto.specializationId)
                .orElseThrow(() -> new RuntimeException("Specialization not found"));

        Doctor doctor = new Doctor();
        doctor.setName(dto.name);
        doctor.setQualification(dto.qualification);
        doctor.setExperience(dto.experience);
        doctor.setDesignation(dto.designation);
        doctor.setSpecialization(specialization);

        Doctor saved = doctorRepository.save(doctor);

        DoctorResponseDTO response = new DoctorResponseDTO();
        response.id = saved.getId();
        response.name = saved.getName();
        response.specialization = saved.getSpecialization().getName();
        response.experience = saved.getExperience();

        return response;
    }

    @Override
    public DoctorResponseDTO updateDoctor(Long id, DoctorRequestDTO dto) {

        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        doctor.setName(dto.name);
        doctor.setQualification(dto.qualification);
        doctor.setExperience(dto.experience);
        doctor.setDesignation(dto.designation);

        Doctor updated = doctorRepository.save(doctor);

        DoctorResponseDTO response = new DoctorResponseDTO();
        response.id = updated.getId();
        response.name = updated.getName();
        response.specialization = updated.getSpecialization().getName();
        response.experience = updated.getExperience();

        return response;
    }

    @Override
    public void deleteDoctor(Long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public DoctorResponseDTO getDoctorById(Long id) {

        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        DoctorResponseDTO response = new DoctorResponseDTO();
        response.id = doctor.getId();
        response.name = doctor.getName();
        response.specialization = doctor.getSpecialization().getName();
        response.experience = doctor.getExperience();

        return response;
    }

    @Override
    public List<DoctorResponseDTO> getAllDoctors() {

        return doctorRepository.findAll()
                .stream()
                .map(d -> {
                    DoctorResponseDTO dto = new DoctorResponseDTO();
                    dto.id = d.getId();
                    dto.name = d.getName();
                    dto.specialization = d.getSpecialization().getName();
                    dto.experience = d.getExperience();
                    return dto;
                }).collect(Collectors.toList());
    }
}