package com.wipro.amazecare.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wipro.amazecare.dto.MedicalTestDTO;
import com.wipro.amazecare.entity.MedicalTest;
import com.wipro.amazecare.repository.MedicalTestRepository;
import com.wipro.amazecare.service.MedicalTestService;
@Service
public class MedicalTestServiceImpl implements MedicalTestService {

    private final MedicalTestRepository repository;

    public MedicalTestServiceImpl(MedicalTestRepository repository) {
        this.repository = repository;
    }

    @Override
    public MedicalTestDTO createTest(MedicalTestDTO dto) {

        MedicalTest t = new MedicalTest();
        t.setTestName(dto.getTestName());
        t.setResult(dto.getResult());
        t.setStatus(dto.getStatus());
        t.setCost(dto.getCost());
        t.setTestDate(dto.getTestDate());

        return map(repository.save(t));
    }

    @Override
    public MedicalTestDTO getTestById(Long id) {
        return map(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Test not found")));
    }

    @Override
    public List<MedicalTestDTO> getAllTests() {
        return repository.findAll().stream()
                .map(this::map)
                .toList();
    }

    @Override
    public MedicalTestDTO updateTest(Long id, MedicalTestDTO dto) {

        MedicalTest t = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Test not found"));

        t.setTestName(dto.getTestName());
        t.setResult(dto.getResult());
        t.setStatus(dto.getStatus());
        t.setCost(dto.getCost());
        t.setTestDate(dto.getTestDate());

        return map(repository.save(t));
    }

    @Override
    public void deleteTest(Long id) {
        repository.deleteById(id);
    }

    private MedicalTestDTO map(MedicalTest t){
        MedicalTestDTO dto = new MedicalTestDTO();
        dto.setTestId(t.getTestId());
        dto.setTestName(t.getTestName());
        dto.setResult(t.getResult());
        dto.setStatus(t.getStatus());
        dto.setCost(t.getCost());
        dto.setTestDate(t.getTestDate());
        return dto;
    }
}