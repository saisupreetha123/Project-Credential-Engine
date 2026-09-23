package com.klu.controller;

import com.klu.entity.Verification;
import com.klu.service.VerificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/verify")
public class VerificationController {

    private final VerificationService verificationService;

    public VerificationController(
            VerificationService verificationService) {
        this.verificationService = verificationService;
    }

    @GetMapping("/{certificateId}")
    public ResponseEntity<Verification> verifyCertificate(
            @PathVariable String certificateId) {

        return ResponseEntity.ok(
                verificationService.verifyCertificate(certificateId)
        );
    }
}