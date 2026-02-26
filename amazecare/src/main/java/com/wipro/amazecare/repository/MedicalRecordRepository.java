package com.wipro.amazecare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.amazecare.entity.MedicalRecord;

public interface MedicalRecordRepository
        extends JpaRepository<MedicalRecord, Long> {
}