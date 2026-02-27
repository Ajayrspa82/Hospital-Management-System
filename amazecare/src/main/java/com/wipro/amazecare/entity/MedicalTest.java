package com.wipro.amazecare.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "medical_tests")
public class MedicalTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "test_id")
    private Long testId;

    @Column(name = "test_name")
    private String testName;

    @Column(name = "result")
    private String result;

    @Column(name = "status")
    private String status;

    @Column(name = "cost")
    private double cost;

    @Column(name = "test_date")
    private String testDate;

    @ManyToOne
    @JoinColumn(name = "record_id")
    private MedicalRecord medicalRecord;

    public MedicalTest(){}
    
    

    public MedicalTest(Long testId, String testName, String result, String status, double cost, String testDate,
			MedicalRecord medicalRecord) {
		super();
		this.testId = testId;
		this.testName = testName;
		this.result = result;
		this.status = status;
		this.cost = cost;
		this.testDate = testDate;
		this.medicalRecord = medicalRecord;
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

    public MedicalRecord getMedicalRecord() { return medicalRecord; }
    public void setMedicalRecord(MedicalRecord medicalRecord) { this.medicalRecord = medicalRecord; }
}