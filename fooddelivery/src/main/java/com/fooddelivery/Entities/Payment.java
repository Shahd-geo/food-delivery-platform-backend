package com.fooddelivery.Entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment extends BaseEntity {
    private String paymentMethod;
    private String status;
    private Double amount;
    private String transactionRef;
    private String processedAt;
}
