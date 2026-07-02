package com.fooddelivery.Controllers;

import com.fooddelivery.Dto.CustomerRequestDTO;
import com.fooddelivery.Dto.CustomerResponseDTO;
import com.fooddelivery.Services.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    //Create new customer
    @PostMapping
    public ResponseEntity<CustomerResponseDTO> createCustomer(@RequestBody @Valid CustomerRequestDTO dto) {
        CustomerResponseDTO response = customerService.createCustomer(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping
    public ResponseEntity<List<CustomerResponseDTO>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers()
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> getCustomerById(
            @PathVariable Integer id) {

        return ResponseEntity.ok(
                customerService.getCustomerById(id)
        );
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<CustomerResponseDTO> getCustomerByEmail(@PathVariable String email) {
        return ResponseEntity.ok(customerService.findByEmail(email)
        );
    }
}
