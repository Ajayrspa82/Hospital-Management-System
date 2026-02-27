package com.wipro.amazecare.service;

import java.util.List;

import com.wipro.amazecare.dto.TestRecommendationDTO;

public interface TestRecommendationService {

    TestRecommendationDTO createRecommendation(TestRecommendationDTO dto);

    TestRecommendationDTO getById(Long id);

    List<TestRecommendationDTO> getAll();

    TestRecommendationDTO update(Long id, TestRecommendationDTO dto);

    void delete(Long id);

	TestRecommendationDTO create(TestRecommendationDTO dto);
}