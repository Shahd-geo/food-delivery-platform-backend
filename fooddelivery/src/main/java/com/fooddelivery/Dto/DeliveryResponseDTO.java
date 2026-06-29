package com.fooddelivery.Dto;

public class DeliveryResponseDTO {
    private Integer id;
    private String trackingCode;
    private String status;
    private String assignedAt;
    private String pickedUpAt;
    private String deliveredAt;
    private OrderResponseDTO order;
}
