package com.dalourhossan.ecommerce.repository;

import com.dalourhossan.ecommerce.entity.Customer;
import com.dalourhossan.ecommerce.entity.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long> {
    Customer findByCustomerId(Long customerId);
}
