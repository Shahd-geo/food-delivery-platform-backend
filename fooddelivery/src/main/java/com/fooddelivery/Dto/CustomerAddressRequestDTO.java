package com.fooddelivery.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
