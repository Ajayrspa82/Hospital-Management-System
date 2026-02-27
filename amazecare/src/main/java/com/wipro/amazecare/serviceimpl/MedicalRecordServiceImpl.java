package com.wipro.amazecare.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wipro.amazecare.dto.MedicalRecordDTO;
import com.wipro.amazecare.entity.MedicalRecord;
import com.wipro.amazecare.entity.Patient;
import com.wipro.amazecare.repository.MedicalRecordRepository;
import com.wipro.amazecare.repository.PatientRepository;
import com.wipro.amazecare.service.MedicalRecordService;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {

    private final MedicalRecordRepository recordRepo;
    private final PatientRepository patientRepo;

    public MedicalRecordServiceImpl(MedicalRecordRepository recordRepo,
                                    PatientRepository patientRepo) {
        this.recordRepo = recordRepo;
        this.patientRepo = patientRepo;
    }

    // CREATE
    @Override
    public MedicalRecordDTO createRecord(MedicalRecordDTO dto) {

        Patient patient = patientRepo.findById(dto.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        MedicalRecord record = new MedicalRecord();
        record.setDiagnosis(dto.getDiagnosis());
        record.setTreatment(dto.getTreatment());
        record.setVisitDate(dto.getVisitDate());
        record.setBillAmount(dto.getBillAmount());
        record.setNotes(dto.getNotes());
        record.setPatient(patient);

        return map(recordRepo.save(record));
    }

    // GET BY ID
    @Override
    public MedicalRecordDTO getById(Long id) {
        return map(recordRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found")));
    }

    // GET ALL
    @Override
    public List<MedicalRecordDTO> getAll() {
        return recordRepo.findAll()
                .stream()
                .map(this::map)
                .toList();
    }

    // UPDATE
    @Override
    public MedicalRecordDTO update(Long id, MedicalRecordDTO dto) {

        MedicalRecord record = recordRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Record not found"));

        record.setDiagnosis(dto.getDiagnosis());
        record.setTreatment(dto.getTreatment());
        record.setVisitDate(dto.getVisitDate());
        record.setBillAmount(dto.getBillAmount());
        record.setNotes(dto.getNotes());

        return map(recordRepo.save(record));
    }

    // DELETE
    @Override
    public void delete(Long id) {
        recordRepo.deleteById(id);
    }

    // MAPPER
    private MedicalRecordDTO map(MedicalRecord r){
        MedicalRecordDTO dto = new MedicalRecordDTO();

        dto.setRecordId(r.getRecordId());
        dto.setDiagnosis(r.getDiagnosis());
        dto.setTreatment(r.getTreatment());
        dto.setVisitDate(r.getVisitDate());
        dto.setBillAmount(r.getBillAmount());
        dto.setNotes(r.getNotes());

        if(r.getPatient()!=null)
            dto.setPatientId(r.getPatient().getPatientId());

        return dto;
    }

	@Override
	public MedicalRecordDTO getRecordById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MedicalRecordDTO> getRecordsByPatient(Long patientId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRecord(Long id) {
		// TODO Auto-generated method stub
		
	}
}