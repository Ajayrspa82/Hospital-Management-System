package com.wipro.amazecare.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.amazecare.dto.DoctorSpecializationDTO;
import com.wipro.amazecare.service.DoctorSpecializationService;

@RestController
@RequestMapping("/api/specializations")
public class DoctorSpecializationController {

    @Autowired
    private DoctorSpecializationService service;

    @PostMapping
    public DoctorSpecializationDTO addSpecialization(@RequestBody DoctorSpecializationDTO dto) {
        return service.addSpecialization(dto);
    }

    @GetMapping
    public List<DoctorSpecializationDTO> getAllSpecializations() {
        return service.getAllSpecializations();
    }
}