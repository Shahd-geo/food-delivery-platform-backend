package com.fooddelivery.Entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Delivery extends BaseEntity{
    private String trackingCode;
    private String status;
    private String assignedAt;
    private String pickedUpAt;
    private String deliveredAt;

}
