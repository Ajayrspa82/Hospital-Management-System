package com.wipro.amazecare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.amazecare.entity.DoctorSpecialization;

public interface DoctorSpecializationRepository
        extends JpaRepository<DoctorSpecialization, Long> {
}