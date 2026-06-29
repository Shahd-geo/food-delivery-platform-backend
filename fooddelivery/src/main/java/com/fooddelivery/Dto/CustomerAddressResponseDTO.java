package com.fooddelivery.Dto;

import com.fooddelivery.Entities.CustomerAddress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerAddressResponseDTO {
    private Integer id;
    private String street;
    private String city;
    private String building;
    private Boolean isDefault;

    public static CustomerAddressResponseDTO fromEntity(CustomerAddress address) {
        CustomerAddressResponseDTO dto = new CustomerAddressResponseDTO();
        dto.setId(address.getId());
        dto.setStreet(address.getStreet());
        dto.setCity(address.getCity());
        dto.setBuilding(address.getBuilding());
        dto.setIsDefault(address.getIsDefault());
        return dto;
    }
}
