package com.wipro.amazecare.dto;

public class MedicalRecordDTO {

    private Long recordId;
    private String diagnosis;
    private String treatment;
    private String visitDate;
    private double billAmount;
    private String notes;
    private Long patientId;

    public MedicalRecordDTO(){}

    public MedicalRecordDTO(Long recordId, String diagnosis, String treatment, String visitDate, double billAmount,
			String notes, Long patientId) {
		super();
		this.recordId = recordId;
		this.diagnosis = diagnosis;
		this.treatment = treatment;
		this.visitDate = visitDate;
		this.billAmount = billAmount;
		this.notes = notes;
		this.patientId = patientId;
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

    public Long getPatientId() { return patientId; }
    public void setPatientId(Long patientId) { this.patientId = patientId; }
}