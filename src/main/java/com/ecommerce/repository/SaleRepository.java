package com.ecommerce.repository;

import com.ecommerce.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

public interface SaleRepository extends JpaRepository<Sale, UUID> {
    @Query("SELECT SUM(s.totalAmount) FROM Sale s WHERE s.saleDate = :saleDate")
    Optional<Double> sumTotalAmountBySaleDate(@Param("saleDate") LocalDate saleDate);

    @Query("SELECT s.saleDate FROM Sale s WHERE s.saleDate BETWEEN :startDate AND :endDate GROUP BY s.saleDate ORDER BY SUM(s.totalAmount) DESC")
    Optional<LocalDate> findMaxSaleDayWithinDateRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
