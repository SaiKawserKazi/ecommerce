package com.ecommerce.repository;

import com.ecommerce.dto.TopSellingItemDTO;
import com.ecommerce.entity.SaleItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.UUID;
import java.util.List;

public interface SaleItemRepository extends JpaRepository<SaleItem, UUID> {
    List<SaleItem> findTop5ByOrderByQuantityDesc();
    List<SaleItem> findTop5BySaleSaleDateBetweenOrderByQuantityDesc(LocalDate startDate, LocalDate endDate);

    @Query("SELECT new com.ecommerce.dto.TopSellingItemDTO(si.product.productId, si.product.name, SUM(si.quantity * si.price)) " +
            "FROM SaleItem si " +
            "GROUP BY si.product.productId, si.product.name " +
            "ORDER BY SUM(si.quantity * si.price) DESC")
    List<TopSellingItemDTO> findTopSellingItems();

    @Query("SELECT new com.ecommerce.dto.TopSellingItemDTO(si.product.productId, si.product.name, COUNT(si.product.productId)) " +
            "FROM SaleItem si " +
            "JOIN si.sale s " +
            "WHERE s.saleDate BETWEEN :startDate AND :endDate " +
            "GROUP BY si.product.productId, si.product.name " +
            "ORDER BY COUNT(si.product.productId) DESC")
    List<TopSellingItemDTO> findTopSellingItemsOfLastMonth(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

}
