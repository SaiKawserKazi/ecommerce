package com.ecommerce.service;

import com.ecommerce.dto.TopSellingItemDTO;
import org.hibernate.query.Page;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface SaleService {
    public Optional<Double> getTotalSaleAmountForToday();
    public Optional<LocalDate> getMaxSaleDay(LocalDate startDate, LocalDate endDate);
    public List<TopSellingItemDTO> getTopSellingItemsOfAllTime();
    public List<TopSellingItemDTO> getTopSellingItemsOfLastMonth();
}
