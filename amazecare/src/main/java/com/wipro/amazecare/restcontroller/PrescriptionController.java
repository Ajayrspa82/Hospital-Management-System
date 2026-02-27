package com.wipro.amazecare.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.amazecare.dto.PrescriptionDTO;
import com.wipro.amazecare.service.PrescriptionService;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    @Autowired
    private PrescriptionService service;

    @PostMapping("/{consultationId}")
    public PrescriptionDTO addPrescription(
            @PathVariable Long consultationId,
            @RequestBody PrescriptionDTO dto) {

        return service.addPrescription(consultationId, dto);
    }

    @GetMapping("/{consultationId}")
    public List<PrescriptionDTO> getPrescriptions(
            @PathVariable Long consultationId) {

        return service.getPrescriptionsByConsultation(consultationId);
    }
}