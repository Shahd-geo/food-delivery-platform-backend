package com.fooddelivery.Dto;

import com.fooddelivery.Entities.Payment;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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

    public Payment toEntity() {
        Payment payment = new Payment();
        payment.setPaymentMethod(this.paymentMethod);
        payment.setStatus(this.status);
        payment.setAmount(this.amount);
        payment.setTransactionRef(this.transactionRef);

        return payment;
    }
}
