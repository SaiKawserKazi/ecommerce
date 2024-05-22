package com.ecommerce.repository;

import com.ecommerce.entity.Sale;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface SaleRepository extends JpaRepository<Sale, UUID> {
    @Query("SELECT SUM(s.totalAmount) FROM Sale s WHERE s.saleDate = :saleDate")
    Optional<Double> sumTotalAmountBySaleDate(@Param("saleDate") LocalDate saleDate);

    @Query(value = "SELECT DISTINCT s.sale_date, SUM(s.total_amount) as total_amount " +
            "FROM sale s " +
            "WHERE s.sale_date BETWEEN :startDate AND :endDate " +
            "GROUP BY s.sale_date " +
            "ORDER BY total_amount DESC, s.sale_date DESC " +
            "LIMIT 1", nativeQuery = true)
    Optional<LocalDate> findMaxSaleDayWithinDateRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

}
