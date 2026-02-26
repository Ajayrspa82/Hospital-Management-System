package com.wipro.amazecare.dto;

import java.time.LocalDate;

public class ConsultationRequestDTO {
    public Long appointmentId;
    public String symptoms;
    public String diagnosis;
    public String treatmentPlan;
    public LocalDate consultationDate;
}