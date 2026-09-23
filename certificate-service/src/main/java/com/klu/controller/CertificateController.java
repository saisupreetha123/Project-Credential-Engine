package com.klu.controller;

import com.klu.entity.Certificate;
import com.klu.service.CertificateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/certificates")
public class CertificateController {

    private final CertificateService certificateService;

    public CertificateController(
            CertificateService certificateService) {
        this.certificateService = certificateService;
    }

    @PostMapping
    public ResponseEntity<Certificate> issueCertificate(
            @RequestBody Certificate certificate) {

        return ResponseEntity.ok(
                certificateService.issueCertificate(certificate)
        );
    }

    @GetMapping("/{certificateId}")
    public ResponseEntity<Certificate> getCertificate(
            @PathVariable String certificateId) {

        return ResponseEntity.ok(
                certificateService.getCertificate(certificateId)
        );
    }
}