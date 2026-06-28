package com.fooddelivery.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantOwner extends BaseEntity {
    private String firstName;
    private String lastName;
@Email
    private String email;
    private String phone;
    private String passwordHash;
    private String businessLicenseCode;
    @OneToMany
    private List<Restaurant> restaurants;
}
