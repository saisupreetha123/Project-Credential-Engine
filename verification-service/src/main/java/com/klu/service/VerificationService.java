package com.klu.service;

import com.klu.client.CertificateClient;
import com.klu.client.CertificateResponse;
import com.klu.entity.Verification;
import org.springframework.stereotype.Service;

@Service
public class VerificationService {

    private final CertificateClient certificateClient;

    public VerificationService(CertificateClient certificateClient) {
        this.certificateClient = certificateClient;
    }

    public Verification verifyCertificate(String certificateId) {

        Verification verification = new Verification();

        try {

            CertificateResponse certificate =
                    certificateClient.getCertificate(certificateId);

            if (certificate != null &&
                    "ISSUED".equalsIgnoreCase(certificate.getStatus())) {

                verification.setCertificateId(certificateId);
                verification.setValid(true);
                verification.setMessage(
                        "Certificate is valid and authentic");

            } else {

                verification.setCertificateId(certificateId);
                verification.setValid(false);
                verification.setMessage(
                        "Certificate is not valid");
            }

        } catch (Exception e) {

            verification.setCertificateId(certificateId);
            verification.setValid(false);
            verification.setMessage(
                    "Certificate not found");
        }

        return verification;
    }
}