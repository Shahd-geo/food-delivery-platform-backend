package com.fooddelivery.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@
public class CustomerAddressRequestDTO {
    @NotBlank
    private String street;

    @NotBlank
    private String city;

    @NotBlank
    private String building;

    @NotNull
    private Boolean isDefault;

}
