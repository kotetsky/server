package com.spikart.back.model;

public class PaymentDetails {

    private String paymentMethod;
    private String status;
    private String paymentId;
    private String razorPayPaymentLinkId;
    private String razorPayPaymentLinkReferenceId;
    private String razorPayPaymentLinkStatus;
    private String getRazorPayPaymentId;

    public PaymentDetails() {

    }

    public PaymentDetails(
            String paymentMethod,
            String status,
            String paymentId,
            String razorPayPaymentLinkId,
            String razorPayPaymentLinkReferenceId,
            String razorPayPaymentLinkStatus,
            String getRazorPayPaymentId
    ) {
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.paymentId = paymentId;
        this.razorPayPaymentLinkId = razorPayPaymentLinkId;
        this.razorPayPaymentLinkReferenceId = razorPayPaymentLinkReferenceId;
        this.razorPayPaymentLinkStatus = razorPayPaymentLinkStatus;
        this.getRazorPayPaymentId = getRazorPayPaymentId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getRazorPayPaymentLinkId() {
        return razorPayPaymentLinkId;
    }

    public void setRazorPayPaymentLinkId(String razorPayPaymentLinkId) {
        this.razorPayPaymentLinkId = razorPayPaymentLinkId;
    }

    public String getRazorPayPaymentLinkReferenceId() {
        return razorPayPaymentLinkReferenceId;
    }

    public void setRazorPayPaymentLinkReferenceId(String razorPayPaymentLinkReferenceId) {
        this.razorPayPaymentLinkReferenceId = razorPayPaymentLinkReferenceId;
    }

    public String getGetRazorPayPaymentId() {
        return getRazorPayPaymentId;
    }

    public void setGetRazorPayPaymentId(String getRazorPayPaymentId) {
        this.getRazorPayPaymentId = getRazorPayPaymentId;
    }

    public String getRazorPayPaymentLinkStatus() {
        return razorPayPaymentLinkStatus;
    }

    public void setRazorPayPaymentLinkStatus(String razorPayPaymentLinkStatus) {
        this.razorPayPaymentLinkStatus = razorPayPaymentLinkStatus;
    }
}
