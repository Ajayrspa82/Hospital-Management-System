package com.wipro.amazecare.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wipro.amazecare.dto.PatientCreateDTO;
import com.wipro.amazecare.dto.PatientResponseDTO;
import com.wipro.amazecare.dto.PatientUpdateDTO;
import com.wipro.amazecare.entity.Patient;
import com.wipro.amazecare.repository.PatientRepository;
import com.wipro.amazecare.service.PatientService;
@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepository repository;

    public PatientServiceImpl(PatientRepository repository) {
        this.repository = repository;
    }

    @Override
    public PatientResponseDTO createPatient(PatientCreateDTO dto) {

        Patient p = new Patient();
        p.setFirstName(dto.getFirstName());
        p.setLastName(dto.getLastName());
        p.setAge(dto.getAge());
        p.setGender(dto.getGender());
        p.setPhone(dto.getPhone());
        p.setAddress(dto.getAddress());

        return map(repository.save(p));
    }

    @Override
    public PatientResponseDTO updatePatient(PatientUpdateDTO dto) {

        Patient p = repository.findById(dto.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        p.setFirstName(dto.getFirstName());
        p.setLastName(dto.getLastName());
        p.setAge(dto.getAge());
        p.setGender(dto.getGender());
        p.setPhone(dto.getPhone());
        p.setAddress(dto.getAddress());

        return map(repository.save(p));
    }

    @Override
    public PatientResponseDTO getPatientById(Long id) {
        return map(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found")));
    }

    @Override
    public List<PatientResponseDTO> getAllPatients() {
        return repository.findAll().stream()
                .map(this::map)
                .toList();
    }

    @Override
    public void deletePatient(Long id) {
        repository.deleteById(id);
    }

    private PatientResponseDTO map(Patient p){
        PatientResponseDTO dto = new PatientResponseDTO();
        dto.setPatientId(p.getPatientId());
        dto.setFirstName(p.getFirstName());
        dto.setLastName(p.getLastName());
        dto.setAge(p.getAge());
        dto.setGender(p.getGender());
        dto.setPhone(p.getPhone());
        dto.setAddress(p.getAddress());
        return dto;
    }

	@Override
	public PatientResponseDTO updatePatient(Long id, PatientUpdateDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
}