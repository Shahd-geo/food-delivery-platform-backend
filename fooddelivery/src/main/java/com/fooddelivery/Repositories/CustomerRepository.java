package com.fooddelivery.Repositories;

import com.fooddelivery.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("""
       SELECT c
       FROM Customer c
       WHERE c.email = :email
       AND c.isActive = true
       """)
    Optional<Customer> findByEmail(@Param("email") String email);
}
