package com.wipro.amazecare.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "medical_records")
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private Long recordId;

    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "treatment")
    private String treatment;

    @Column(name = "visit_date")
    private String visitDate;

    @Column(name = "bill_amount")
    private double billAmount;

    @Column(name = "notes")
    private String notes;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @OneToMany(mappedBy = "medicalRecord", cascade = CascadeType.ALL)
    private List<MedicalTest> tests;

    @OneToMany(mappedBy = "medicalRecord", cascade = CascadeType.ALL)
    private List<TestRecommendation> recommendations;

    public MedicalRecord() {}
    
    

    public MedicalRecord(Long recordId, String diagnosis, String treatment, String visitDate, double billAmount,
			String notes, Patient patient, List<MedicalTest> tests, List<TestRecommendation> recommendations) {
		super();
		this.recordId = recordId;
		this.diagnosis = diagnosis;
		this.treatment = treatment;
		this.visitDate = visitDate;
		this.billAmount = billAmount;
		this.notes = notes;
		this.patient = patient;
		this.tests = tests;
		this.recommendations = recommendations;
	}



	public Long getRecordId() { return recordId; }
    public void setRecordId(Long recordId) { this.recordId = recordId; }

    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    public String getTreatment() { return treatment; }
    public void setTreatment(String treatment) { this.treatment = treatment; }

    public String getVisitDate() { return visitDate; }
    public void setVisitDate(String visitDate) { this.visitDate = visitDate; }

    public double getBillAmount() { return billAmount; }
    public void setBillAmount(double billAmount) { this.billAmount = billAmount; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }

    public List<MedicalTest> getTests() { return tests; }
    public void setTests(List<MedicalTest> tests) { this.tests = tests; }

    public List<TestRecommendation> getRecommendations() { return recommendations; }
    public void setRecommendations(List<TestRecommendation> recommendations) { this.recommendations = recommendations; }
}