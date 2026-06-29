package com.fooddelivery.Dto;

import com.fooddelivery.Entities.RestaurantOwner;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantOwnerResponseDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String businessLicenseCode;

    public static RestaurantOwnerResponseDTO fromEntity(RestaurantOwner owner) {

        RestaurantOwnerResponseDTO dto = new RestaurantOwnerResponseDTO();

        dto.setId(owner.getId());
        dto.setFirstName(owner.getFirstName());
        dto.setLastName(owner.getLastName());
        dto.setEmail(owner.getEmail());
        dto.setPhone(owner.getPhone());
        dto.setBusinessLicenseCode(owner.getBusinessLicenseCode());

        return dto;
    }
}
