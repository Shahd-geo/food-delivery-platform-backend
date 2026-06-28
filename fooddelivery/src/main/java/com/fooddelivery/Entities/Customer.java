package com.fooddelivery.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends BaseEntity{
    private String firstName;
    private String lastName;
    @Email
    @NotBlank
    @Column(unique = true)
    private String email;
    private String phone;
    private String passwordHash;
    private Integer loyaltyPoints;
    private String customerCode;
    @OneToMany
    private List<CustomerAddress> customerAddresses;
    @OneToMany
    private List<Order> orders;
}
