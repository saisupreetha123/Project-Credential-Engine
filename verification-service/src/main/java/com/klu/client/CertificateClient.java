package com.klu.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CERTIFICATE-SERVICE")
public interface CertificateClient {

    @GetMapping("/certificates/{certificateId}")
    CertificateResponse getCertificate(
            @PathVariable("certificateId") String certificateId);
}