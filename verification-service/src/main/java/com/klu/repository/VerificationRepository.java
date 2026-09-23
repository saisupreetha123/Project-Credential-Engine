package com.klu.repository;

import com.klu.entity.Verification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VerificationRepository
        extends JpaRepository<Verification, Long> {

    Optional<Verification> findByCertificateId(String certificateId);
}