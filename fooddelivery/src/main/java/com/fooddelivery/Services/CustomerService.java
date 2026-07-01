package com.fooddelivery.Services;

import com.fooddelivery.Dto.CustomerAddressRequestDTO;
import com.fooddelivery.Dto.CustomerAddressResponseDTO;
import com.fooddelivery.Dto.CustomerRequestDTO;
import com.fooddelivery.Dto.CustomerResponseDTO;
import com.fooddelivery.Entities.Customer;
import com.fooddelivery.Entities.CustomerAddress;
import com.fooddelivery.Exceptions.ResourceNotFoundException;
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
    public CustomerResponseDTO createCustomer(CustomerRequestDTO dto, CustomerAddressRequestDTO initialAddress) {
        Customer customer = dto.toEntity();
        customerRepository.save(customer);
        CustomerAddress address = initialAddress.toEntity();
        address.setCustomer(customer);
        customerAddressRepository.save(address);
        return CustomerResponseDTO.fromEntity(customer);
    }

    public CustomerAddressResponseDTO addAddress(Integer customerId, CustomerAddressRequestDTO addressDto) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        CustomerAddress address = addressDto.toEntity();
        address.setCustomer(customer);
        customerAddressRepository.save(address);
        return CustomerAddressResponseDTO.fromEntity(address);
    }
    public CustomerResponseDTO updateLoyaltyPoints(Integer customerId, int points) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));

        customer.setLoyaltyPoints(customer.getLoyaltyPoints() + points);

        customerRepository.save(customer);
        return CustomerResponseDTO.fromEntity(customer);
    }
    public CustomerResponseDTO applyLoyaltyPenalty(Integer customerId, int pointsDeducted) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        customer.setLoyaltyPoints(customer.getLoyaltyPoints() - pointsDeducted);
        customerRepository.save(customer);
        return CustomerResponseDTO.fromEntity(customer);
    }

}
