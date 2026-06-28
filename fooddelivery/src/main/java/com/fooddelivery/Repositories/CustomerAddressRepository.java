package com.fooddelivery.Repositories;

import com.fooddelivery.Entities.CustomerAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerAddressRepository extends JpaRepository<CustomerAddress, Integer> {
    @Query("""
       SELECT ca
       FROM CustomerAddress ca
       WHERE ca.city = :city
       AND ca.isActive = true
       """)
    List<CustomerAddress> findByCity(@Param("city") String city);
}
