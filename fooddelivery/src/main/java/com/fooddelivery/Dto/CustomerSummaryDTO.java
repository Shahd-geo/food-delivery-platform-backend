package com.fooddelivery.Dto;

import com.fooddelivery.Entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerSummaryDTO {
    private Integer id;
    private String firstName;
    private String lastName;

    public static CustomerSummaryDTO fromEntity(Customer customer) {
        CustomerSummaryDTO dto = new CustomerSummaryDTO();
        dto.setId(customer.getId());
        dto.setFirstName(customer.getFirstName());
        dto.setLastName(customer.getLastName());
        return dto;
    }
}

