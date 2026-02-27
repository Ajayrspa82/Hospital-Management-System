package com.wipro.amazecare.dto;

public class TestRecommendationDTO {

    private Long recommendationId;
    private String testName;
    private String reason;
    private String priority;
    private String remarks;
    private Long recordId;

    public TestRecommendationDTO(){}
    
    

    public TestRecommendationDTO(Long recommendationId, String testName, String reason, String priority, String remarks,
			Long recordId) {
		super();
		this.recommendationId = recommendationId;
		this.testName = testName;
		this.reason = reason;
		this.priority = priority;
		this.remarks = remarks;
		this.recordId = recordId;
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

    public Long getRecordId() { return recordId; }
    public void setRecordId(Long recordId) { this.recordId = recordId; }
}