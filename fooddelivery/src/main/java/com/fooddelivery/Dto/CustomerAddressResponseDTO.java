package com.fooddelivery.Dto;

import com.fooddelivery.Entities.CustomerAddress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

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
    public static List<CustomerAddressResponseDTO> fromEntity(
            List<CustomerAddress> addresses) {
        List<CustomerAddressResponseDTO> dtos = new ArrayList<>();

        for (CustomerAddress address : addresses) {
            dtos.add(fromEntity(address));
        }

        return dtos;
    }
}
