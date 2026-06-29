package com.fooddelivery.Dto;

import java.time.LocalDateTime;

public class CorporateOrderResponseDTO {
    private Integer id;
    private String corporateCode;
    private String companyName;
    private String costCenter;
    private LocalDateTime orderDate;
    private String status;
    private Double totalAmount;
    private RestaurantSummaryDTO restaurant;
}
