package com.fooddelivery.Dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ReviewRequestDTO {
    @NotBlank
    private String targetType;
    @NotNull
    @Min(1)
    @Max(5)
    private Integer rating;
    @NotBlank
    private String comment;
}
