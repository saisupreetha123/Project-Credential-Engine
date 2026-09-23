package com.klu.client;

import java.time.LocalDate;

public class CertificateResponse {

    private Long id;
    private String certificateId;
    private String recipientName;
    private String courseName;
    private String issuer;
    private LocalDate issueDate;
    private String status;

    public CertificateResponse() {
    }

    public Long getId() {
        return id;
    }

    public String getCertificateId() {
        return certificateId;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getIssuer() {
        return issuer;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCertificateId(String certificateId) {
        this.certificateId = certificateId;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}