package com.fooddelivery.Dto;

public class PaymentResponseDTO {
    private Integer id;
    private String paymentMethod;
    private String status;
    private Double amount;
    private String transactionRef;
    private String processedAt;
    private OrderSummaryDTO order;
}
