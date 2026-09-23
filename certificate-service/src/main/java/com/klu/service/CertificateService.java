package com.klu.service;

import com.klu.entity.Certificate;

import com.klu.repository.CertificateRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

@Service
public class CertificateService {

    private final CertificateRepository repository;

    public CertificateService(CertificateRepository repository) {
        this.repository = repository;
    }

    public Certificate issueCertificate(Certificate certificate) {

        certificate.setCertificateId("CERT-" + UUID.randomUUID());

        certificate.setIssueDate(LocalDate.now());

        certificate.setStatus("ISSUED");

        certificate.setCertificateHash(
                generateHash(certificate)
        );

        return repository.save(certificate);
    }
    public Certificate getCertificate(String certificateId) {

        return repository.findByCertificateId(certificateId)
                .orElseThrow(() ->
                        new RuntimeException("Certificate not found"));
    }
    
    private String generateHash(Certificate certificate) {

        try {
            String data =
                    certificate.getCertificateId()
                    + certificate.getRecipientName()
                    + certificate.getCourseName()
                    + certificate.getIssuer()
                    + certificate.getIssueDate()
                    + certificate.getStatus();

            MessageDigest digest =
                    MessageDigest.getInstance("SHA-256");

            byte[] hashBytes =
                    digest.digest(data.getBytes(StandardCharsets.UTF_8));

            StringBuilder hexString = new StringBuilder();

            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }

            return hexString.toString();

        } catch (Exception e) {
            throw new RuntimeException("Hash generation failed", e);
        }
    }
}