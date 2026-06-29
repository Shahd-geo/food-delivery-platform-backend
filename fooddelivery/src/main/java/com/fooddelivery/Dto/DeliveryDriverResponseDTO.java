package com.fooddelivery.Dto;

import com.fooddelivery.Entities.DeliveryDriver;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryDriverResponseDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String driverCode;
    private String vehicleType;
    private String vehiclePlate;
    private Double currentLat;
    private Double currentLng;
    private Boolean isOnline;

    public static DeliveryDriverResponseDTO fromEntity(DeliveryDriver driver) {
        DeliveryDriverResponseDTO dto = new DeliveryDriverResponseDTO();

        dto.setId(driver.getId());
        dto.setFirstName(driver.getFirstName());
        dto.setLastName(driver.getLastName());
        dto.setEmail(driver.getEmail());
        dto.setPhone(driver.getPhone());
        dto.setDriverCode(driver.getDriverCode());
        dto.setVehicleType(driver.getVehicleType());
        dto.setVehiclePlate(driver.getVehiclePlate());
        dto.setCurrentLat(driver.getCurrentLat());
        dto.setCurrentLng(driver.getCurrentLng());
        dto.setIsOnline(driver.getIsOnline());

        return dto;
    }
}
