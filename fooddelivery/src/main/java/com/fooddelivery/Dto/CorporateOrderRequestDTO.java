package com.fooddelivery.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;

public class CorporateOrderRequestDTO {
    @NotBlank
    private String corporateCode;
    @NotBlank
    private String companyName;
    @NotBlank
    private String costCenter;
    @Pattern(regexp = "PENDING|CONFIRMED|PREPARING|OUT_FOR_DELIVERY|DELIVERED|CANCELLED")
    private String status;
    @PositiveOrZero
    private Double totalAmount;
    @NotNull
    private Integer restaurantId;
}
