package com.fooddelivery.Entities;

import jakarta.validation.constraints.Email;

public class RestaurantOwner extends BaseEntity {
    private String firstName;
    private String lastName;
@Email
    private String email;
    private String phone;
    private String passwordHash;
    private String businessLicenseCode;
}
