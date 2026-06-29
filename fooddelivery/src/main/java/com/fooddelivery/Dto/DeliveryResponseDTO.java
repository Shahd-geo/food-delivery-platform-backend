package com.fooddelivery.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryResponseDTO {
    private Integer id;
    private String trackingCode;
    private String status;
    private String assignedAt;
    private String pickedUpAt;
    private String deliveredAt;
    private OrderResponseDTO order;
}
