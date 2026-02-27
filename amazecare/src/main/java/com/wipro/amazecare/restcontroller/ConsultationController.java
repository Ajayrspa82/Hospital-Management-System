package com.wipro.amazecare.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.amazecare.dto.ConsultationRequestDTO;
import com.wipro.amazecare.dto.ConsultationResponseDTO;
import com.wipro.amazecare.service.ConsultationService;

@RestController
@RequestMapping("/api/consultations")
public class ConsultationController {

    @Autowired
    private ConsultationService service;

    @PostMapping("/{doctorId}")
    public ConsultationResponseDTO createConsultation(
            @PathVariable Long doctorId,
            @RequestBody ConsultationRequestDTO dto) {

        return service.createConsultation(doctorId, dto);
    }

    @GetMapping("/{id}")
    public ConsultationResponseDTO getConsultation(@PathVariable Long id) {
        return service.getConsultationById(id);
    }
}