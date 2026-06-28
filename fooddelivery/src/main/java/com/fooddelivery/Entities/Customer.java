package com.fooddelivery.Entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends BaseEntity{
    private String firstName;
    private String lastName;
    @UniqueElements
    private String email;
    private String phone;
    private String passwordHash;
    private Integer loyaltyPoints;
    private String customerCode;
}
