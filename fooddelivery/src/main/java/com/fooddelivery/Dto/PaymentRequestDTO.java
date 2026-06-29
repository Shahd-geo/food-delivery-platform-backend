package com.fooddelivery.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;

public class PaymentRequestDTO {
   @NotBlank
    private String paymentMethod;
    @Pattern(regexp = "PENDING|COMPLETED|REFUNDED|FAILED")
    private String status;
    @PositiveOrZero
    private Double amount;
    @NotBlank
    private String transactionRef;
    @NotNull
    private Integer orderId;
}
