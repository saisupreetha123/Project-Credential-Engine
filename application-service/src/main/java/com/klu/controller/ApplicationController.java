package com.klu.controller;

import com.klu.client.CertificateResponse;
import com.klu.entity.Application;
import com.klu.service.ApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(
            ApplicationService applicationService) {

        this.applicationService = applicationService;
    }

    @PostMapping
    public ResponseEntity<Application> submitApplication(
            @RequestBody Application application) {

        return ResponseEntity.ok(
                applicationService.submitApplication(application));
    }

    @PostMapping("/{id}/approve")
    public ResponseEntity<CertificateResponse> approveApplication(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                applicationService.approveApplication(id));
    }
}