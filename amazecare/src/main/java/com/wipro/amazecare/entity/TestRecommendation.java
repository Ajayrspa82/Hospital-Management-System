package com.wipro.amazecare.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "test_recommendations")
public class TestRecommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recommendation_id")
    private Long recommendationId;

    @Column(name = "test_name")
    private String testName;

    @Column(name = "reason")
    private String reason;

    @Column(name = "priority")
    private String priority;

    @Column(name = "remarks")
    private String remarks;

    @ManyToOne
    @JoinColumn(name = "record_id")
    private MedicalRecord medicalRecord;

    public TestRecommendation(){}

    
    public TestRecommendation(Long recommendationId, String testName, String reason, String priority, String remarks,
			MedicalRecord medicalRecord) {
		super();
		this.recommendationId = recommendationId;
		this.testName = testName;
		this.reason = reason;
		this.priority = priority;
		this.remarks = remarks;
		this.medicalRecord = medicalRecord;
	}


	public Long getRecommendationId() { return recommendationId; }
    public void setRecommendationId(Long recommendationId) { this.recommendationId = recommendationId; }

    public String getTestName() { return testName; }
    public void setTestName(String testName) { this.testName = testName; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public String getPriority() { return priority; }
    public void setPriority(String priority) { this.priority = priority; }

    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }

    public MedicalRecord getMedicalRecord() { return medicalRecord; }
    public void setMedicalRecord(MedicalRecord medicalRecord) { this.medicalRecord = medicalRecord; }
}