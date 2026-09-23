package com.klu.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "CERTIFICATE-SERVICE")
public interface CertificateClient {

    @PostMapping("/certificates")
    CertificateResponse issueCertificate(
            @RequestBody CertificateRequest request);
}