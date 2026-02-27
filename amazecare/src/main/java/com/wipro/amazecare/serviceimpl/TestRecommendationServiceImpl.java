package com.wipro.amazecare.serviceimpl;
import java.util.List;

import org.springframework.stereotype.Service;

import com.wipro.amazecare.dto.TestRecommendationDTO;
import com.wipro.amazecare.entity.TestRecommendation;
import com.wipro.amazecare.repository.TestRecommendationRepository;
import com.wipro.amazecare.service.TestRecommendationService;
@Service
public class TestRecommendationServiceImpl implements TestRecommendationService {

    private final TestRecommendationRepository repository;

    public TestRecommendationServiceImpl(TestRecommendationRepository repository) {
        this.repository = repository;
    }

    @Override
    public TestRecommendationDTO create(TestRecommendationDTO dto) {

        TestRecommendation tr = new TestRecommendation();
        tr.setTestName(dto.getTestName());
        tr.setReason(dto.getReason());
        tr.setPriority(dto.getPriority());
        tr.setRemarks(dto.getRemarks());

        return map(repository.save(tr));
    }

    @Override
    public TestRecommendationDTO getById(Long id) {
        return map(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recommendation not found")));
    }

    @Override
    public List<TestRecommendationDTO> getAll() {
        return repository.findAll().stream()
                .map(this::map)
                .toList();
    }

    @Override
    public TestRecommendationDTO update(Long id, TestRecommendationDTO dto) {

        TestRecommendation tr = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recommendation not found"));

        tr.setTestName(dto.getTestName());
        tr.setReason(dto.getReason());
        tr.setPriority(dto.getPriority());
        tr.setRemarks(dto.getRemarks());

        return map(repository.save(tr));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    private TestRecommendationDTO map(TestRecommendation tr){
        TestRecommendationDTO dto = new TestRecommendationDTO();
        dto.setRecommendationId(tr.getRecommendationId());
        dto.setTestName(tr.getTestName());
        dto.setReason(tr.getReason());
        dto.setPriority(tr.getPriority());
        dto.setRemarks(tr.getRemarks());
        return dto;
    }

	@Override
	public TestRecommendationDTO createRecommendation(TestRecommendationDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}
}