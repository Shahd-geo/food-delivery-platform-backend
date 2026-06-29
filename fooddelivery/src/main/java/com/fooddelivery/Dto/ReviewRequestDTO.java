package com.fooddelivery.Dto;

import com.fooddelivery.Entities.Review;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequestDTO {
    @NotBlank
    private String targetType;
    @NotNull
    @Min(1)
    @Max(5)
    private Integer rating;
    @NotBlank
    private String comment;

    public Review toEntity() {
        Review review = new Review();
        review.setTargetType(this.targetType);
        review.setRating(this.rating);
        review.setComment(this.comment);

        return review;
    }
}
