package com.fooddelivery.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComboMealRequestDTO {
    @NotBlank
    private String comboName;
    @NotBlank
    private String description;
    @PositiveOrZero
    private Double totalPrice;
    @NotNull
    private Boolean isAvailable;
}
