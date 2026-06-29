package com.fooddelivery.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class DeliveryRequestDTO {
    @NotBlank
    private String trackingCode;

    @Pattern(regexp = "PENDING|ASSIGNED|PICKED_UP|DELIVERED|CANCELLED")
    private String status;
    private String assignedAt;
    private String pickedUpAt;
    private String deliveredAt;
    @NotNull
    private Integer deliveryDriverId;
    @NotNull
    private Integer orderId;
}
