package com.ecommerce.repository;

import com.ecommerce.dto.TopSellingItemDTO;
import com.ecommerce.entity.SaleItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.UUID;
import java.util.List;
@Repository
public interface SaleItemRepository extends JpaRepository<SaleItem, UUID> {
    List<SaleItem> findTop5ByOrderByQuantityDesc();
    List<SaleItem> findTop5BySaleSaleDateBetweenOrderByQuantityDesc(LocalDate startDate, LocalDate endDate);

    @Query(value = "SELECT si.product_id as productId, p.name as productName, SUM(si.quantity * si.price) as totalSales " +
            "FROM sale_item si " +
            "JOIN product p ON si.product_id = p.product_id " +
            "GROUP BY si.product_id, p.name " +
            "ORDER BY totalSales DESC " +
            "LIMIT 5", nativeQuery = true)
    List<Object[]> findTopSellingItemsNativeQuery();

    @Query(value = "SELECT si.product_id as productId, p.name as productName, COUNT(si.product_id) as totalSales " +
            "FROM sale_item si " +
            "JOIN product p ON si.product_id = p.product_id " +
            "JOIN sale s ON si.sale_id = s.sale_id " +
            "WHERE s.sale_date BETWEEN :startDate AND :endDate " +
            "GROUP BY si.product_id, p.name " +
            "ORDER BY totalSales DESC " +
            "LIMIT 5", nativeQuery = true)
    List<Object[]> findTopSellingItemsOfLastMonth(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
