package com.fooddelivery.Dto;

import com.fooddelivery.Entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Integer loyaltyPoints;
    private String customerCode;

    //IF I have one customer
   public  static CustomerResponseDTO fromEntity(Customer customer) {
        CustomerResponseDTO dto = new CustomerResponseDTO();
        dto.setId(customer.getId());
        dto.setFirstName(customer.getFirstName());
        dto.setLastName(customer.getLastName());
        dto.setEmail(customer.getEmail());
        dto.setPhone(customer.getPhone());
        dto.setLoyaltyPoints(customer.getLoyaltyPoints());
        dto.setCustomerCode(customer.getCustomerCode());

        return dto;
    }
    //IF I HAVE A LIST OF CUSTOMER
    public static List<CustomerResponseDTO> fromEntity(List<Customer> customers) {
        List<CustomerResponseDTO> dtos = new ArrayList<>();

        for (Customer customer : customers) {
            dtos.add(fromEntity(customer));
        }
        return dtos;
    }

}
