package com.fooddelivery.Services;

import com.fooddelivery.Dto.CustomerRequestDTO;
import com.fooddelivery.Dto.CustomerResponseDTO;
import com.fooddelivery.Entities.Customer;
import com.fooddelivery.Repositories.CustomerAddressRepository;
import com.fooddelivery.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerAddressRepository customerAddressRepository;
    public CustomerResponseDTO createCustomer(CustomerRequestDTO dto) {
        Customer customer = dto.toEntity();
        customerRepository.save(customer);
        return CustomerResponseDTO.fromEntity(customer);
    }

}
