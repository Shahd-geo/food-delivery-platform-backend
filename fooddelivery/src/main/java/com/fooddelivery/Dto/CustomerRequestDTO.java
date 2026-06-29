package com.fooddelivery.Dto;

import com.fooddelivery.Entities.Customer;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequestDTO {
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

    public Customer toEntity() {
        Customer customer = new Customer();
        customer.setFirstName(this.firstName);
        customer.setLastName(this.lastName);
        customer.setEmail(this.email);
        customer.setPhone(this.phone);
        customer.setPasswordHash(this.passwordHash);
        return customer;
    }

}
