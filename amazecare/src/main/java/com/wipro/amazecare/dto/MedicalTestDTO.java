package com.wipro.amazecare.dto;

public class MedicalTestDTO {

    private Long testId;
    private String testName;
    private String result;
    private String status;
    private double cost;
    private String testDate;
    private Long recordId;

    public MedicalTestDTO(){}
    
    

    public MedicalTestDTO(Long testId, String testName, String result, String status, double cost, String testDate,
			Long recordId) {
		super();
		this.testId = testId;
		this.testName = testName;
		this.result = result;
		this.status = status;
		this.cost = cost;
		this.testDate = testDate;
		this.recordId = recordId;
	}



	public Long getTestId() { return testId; }
    public void setTestId(Long testId) { this.testId = testId; }

    public String getTestName() { return testName; }
    public void setTestName(String testName) { this.testName = testName; }

    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }

    public String getTestDate() { return testDate; }
    public void setTestDate(String testDate) { this.testDate = testDate; }

    public Long getRecordId() { return recordId; }
    public void setRecordId(Long recordId) { this.recordId = recordId; }
}