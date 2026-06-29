package com.fooddelivery.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class MenuItemRequestDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @PositiveOrZero
    private Double price;
    @NotNull
    private Boolean isAvailable;
    @NotNull
    private Boolean isVegetarian;
    @PositiveOrZero
    private Integer calories;
}
