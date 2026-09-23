package com.klu.service;

import com.klu.client.CertificateClient;
import com.klu.client.CertificateRequest;
import com.klu.client.CertificateResponse;
import com.klu.entity.Application;
import com.klu.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final CertificateClient certificateClient;

    public ApplicationService(
            ApplicationRepository applicationRepository,
            CertificateClient certificateClient) {

        this.applicationRepository = applicationRepository;
        this.certificateClient = certificateClient;
    }

    public Application submitApplication(Application application) {

        application.setStatus("PENDING");
        application.setApplicationDate(LocalDate.now());

        return applicationRepository.save(application);
    }

    public CertificateResponse approveApplication(Long applicationId) {

        Application application =
                applicationRepository.findById(applicationId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Application not found"));

        CertificateRequest request =
                new CertificateRequest(
                        application.getApplicantName(),
                        application.getCourseName(),
                        application.getInstitution()
                );

        CertificateResponse certificate =
                certificateClient.issueCertificate(request);

        application.setStatus("APPROVED");

        applicationRepository.save(application);

        return certificate;
    }
}