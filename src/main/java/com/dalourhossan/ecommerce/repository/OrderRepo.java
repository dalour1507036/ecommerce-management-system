package com.dalourhossan.ecommerce.repository;

import com.dalourhossan.ecommerce.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;


@Repository
@EnableJpaRepositories
public interface OrderRepo extends JpaRepository<Order, Long> {
    @Query("SELECT COALESCE(SUM(oi.quantity * p.price), 0) " +
            "FROM Order o " +
            "JOIN o.orderItems oi " +
            "JOIN oi.product p " +
            "WHERE CAST(o.orderDate AS date) = :currentDate")
    double getTotalSaleAmountForCurrentDay(LocalDate currentDate);
}
