package com.fooddelivery.Dto;

import com.fooddelivery.Entities.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentResponseDTO {
    private Integer id;
    private String paymentMethod;
    private String status;
    private Double amount;
    private String transactionRef;
    private String processedAt;
    private OrderSummaryDTO order;

    public static PaymentResponseDTO fromEntity(Payment payment) {
        PaymentResponseDTO dto = new PaymentResponseDTO();
        dto.setId(payment.getId());
        dto.setPaymentMethod(payment.getPaymentMethod());
        dto.setStatus(payment.getStatus());
        dto.setAmount(payment.getAmount());
        dto.setTransactionRef(payment.getTransactionRef());
        dto.setProcessedAt(payment.getProcessedAt());
        dto.setOrder(OrderSummaryDTO.fromEntity(payment.getOrder()));
        return dto;
    }
}
