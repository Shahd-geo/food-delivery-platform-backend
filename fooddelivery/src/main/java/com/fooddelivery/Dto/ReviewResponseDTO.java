package com.fooddelivery.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewResponseDTO {
    private Integer id;
    private String targetType;
    private Integer rating;
    private String comment;
    private String createdAt;
}
