package com.fooddelivery.Dto;

import com.fooddelivery.Entities.CorporateOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CorporateOrderResponseDTO {
    private Integer id;
    private String corporateCode;
    private String companyName;
    private String costCenter;
    private LocalDateTime orderDate;
    private String status;
    private Double totalAmount;
    private RestaurantSummaryDTO restaurant;

    public static CorporateOrderResponseDTO fromEntity(CorporateOrder corporateOrder) {
        CorporateOrderResponseDTO dto = new CorporateOrderResponseDTO();
        dto.setId(corporateOrder.getId());
        dto.setCorporateCode(corporateOrder.getCorporateCode());
        dto.setCompanyName(corporateOrder.getCompanyName());
        dto.setCostCenter(corporateOrder.getCostCenter());
        dto.setOrderDate(corporateOrder.getOrderDate());
        dto.setStatus(corporateOrder.getStatus());
        dto.setTotalAmount(corporateOrder.getTotalAmount());

        dto.setRestaurant(RestaurantSummaryDTO.fromEntity(corporateOrder.getRestaurant()));

        return dto;
    }
}
