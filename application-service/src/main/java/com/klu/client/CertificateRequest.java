package com.klu.client;

public class CertificateRequest {

    private String recipientName;
    private String courseName;
    private String issuer;

    public CertificateRequest() {
    }

    public CertificateRequest(
            String recipientName,
            String courseName,
            String issuer) {

        this.recipientName = recipientName;
        this.courseName = courseName;
        this.issuer = issuer;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }
}