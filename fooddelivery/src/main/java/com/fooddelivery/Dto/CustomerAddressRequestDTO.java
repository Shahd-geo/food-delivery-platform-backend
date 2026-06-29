package com.fooddelivery.Dto;

import com.fooddelivery.Entities.CustomerAddress;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAddressRequestDTO {
    @NotBlank
    private String street;
    @NotBlank
    private String city;
    @NotBlank
    private String building;
    @NotNull
    private Boolean isDefault;
    public CustomerAddress toEntity() {
        CustomerAddress customerAddress = new CustomerAddress();
        customerAddress.setStreet(this.street);
        customerAddress.setCity(this.city);
        customerAddress.setBuilding(this.building);
        customerAddress.setIsDefault(this.isDefault);
        return customerAddress;
    }
}
