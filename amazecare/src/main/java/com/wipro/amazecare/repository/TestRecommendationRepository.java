package com.wipro.amazecare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wipro.amazecare.entity.TestRecommendation;
import java.util.List;

public interface TestRecommendationRepository extends JpaRepository<TestRecommendation, Long> {

    List<TestRecommendation> findByMedicalRecordRecordId(Long recordId);
}