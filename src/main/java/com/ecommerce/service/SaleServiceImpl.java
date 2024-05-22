package com.ecommerce.service;

import com.ecommerce.dto.TopSellingItemDTO;
import com.ecommerce.repository.SaleItemRepository;
import com.ecommerce.repository.SaleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SaleServiceImpl implements SaleService{

    private final SaleRepository saleRepository;
    private final SaleItemRepository saleItemRepository;

    public SaleServiceImpl(SaleRepository saleRepository,
                           SaleItemRepository saleItemRepository
    ) {
        this.saleRepository = saleRepository;
        this.saleItemRepository = saleItemRepository;
    }

    public Optional<Double> getTotalSaleAmountForToday() {
        LocalDate today = LocalDate.now();
        return saleRepository.sumTotalAmountBySaleDate(today);
    }

    @Override
    public Optional<LocalDate> getMaxSaleDay(LocalDate startDate, LocalDate endDate) {
        return saleRepository.findMaxSaleDayWithinDateRange(startDate, endDate);
    }


    @Override
    public List<TopSellingItemDTO> getTopSellingItemsOfAllTime() {
        List<Object[]> results = saleItemRepository.findTopSellingItemsNativeQuery();
        List<TopSellingItemDTO> dtos = new ArrayList<>();

        for (Object[] result : results) {
            UUID productId = (UUID) result[0];
            String productName = (String) result[1];
            Long totalSales = ((Number) result[2]).longValue();

            TopSellingItemDTO dto = new TopSellingItemDTO(productId, productName, totalSales);
            dtos.add(dto);
        }

        return dtos;
    }

    @Override
    public List<TopSellingItemDTO> getTopSellingItemsOfLastMonth() {
        LocalDate startDate = LocalDate.now().minusMonths(1).withDayOfMonth(1);
        LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());
        List<Object[]> results = saleItemRepository.findTopSellingItemsOfLastMonth(startDate, endDate);
        List<TopSellingItemDTO> dtos = new ArrayList<>();

        for (Object[] result : results) {
            UUID productId = (UUID) result[0];
            String productName = (String) result[1];
            Long totalSales = ((Number) result[2]).longValue(); // Convert to Long

            TopSellingItemDTO dto = new TopSellingItemDTO(productId, productName, totalSales);
            dtos.add(dto);
        }

        return dtos;
    }
}
