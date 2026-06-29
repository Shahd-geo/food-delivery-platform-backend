package com.fooddelivery.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryDriverRequestDTO {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    @Email
    private String email;
    @Pattern(regexp = "^(\\+968)?[0-9]{8}$")
    private String phone;
    @NotBlank
    private String passwordHash;
    @NotBlank
    private String driverCode;
    @NotBlank
    private String vehicleType;
    @NotBlank
    private String vehiclePlate;
    @NotNull
    private Double currentLat;
    @NotNull
    private Double currentLng;
    @NotNull
    private Boolean isOnline;
}
