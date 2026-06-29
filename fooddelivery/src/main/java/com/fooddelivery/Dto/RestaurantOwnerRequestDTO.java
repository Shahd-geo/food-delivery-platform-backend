package com.fooddelivery.Dto;

import com.fooddelivery.Entities.RestaurantOwner;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantOwnerRequestDTO {
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
    private String businessLicenseCode;

    public RestaurantOwner toEntity() {
        RestaurantOwner owner = new RestaurantOwner();
        owner.setFirstName(this.firstName);
        owner.setLastName(this.lastName);
        owner.setEmail(this.email);
        owner.setPhone(this.phone);
        owner.setPasswordHash(this.passwordHash);
        owner.setBusinessLicenseCode(this.businessLicenseCode);

        return owner;
    }
}
