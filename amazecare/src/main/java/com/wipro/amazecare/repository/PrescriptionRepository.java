package com.wipro.amazecare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.amazecare.entity.Prescription;

public interface PrescriptionRepository
        extends JpaRepository<Prescription, Long> {
}