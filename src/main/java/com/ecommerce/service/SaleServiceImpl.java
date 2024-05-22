package com.ecommerce.service;

import com.ecommerce.dto.TopSellingItemDTO;
import com.ecommerce.repository.SaleItemRepository;
import com.ecommerce.repository.SaleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
        return saleItemRepository.findTopSellingItems();
    }

    @Override
    public List<TopSellingItemDTO> getTopSellingItemsOfLastMonth() {
        LocalDate startDate = LocalDate.now().minusMonths(1).withDayOfMonth(1);
        LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());
        return saleItemRepository.findTopSellingItemsOfLastMonth(startDate, endDate);
    }
}
