package com.ecommerce.service;

import com.ecommerce.dto.TopSellingItemDTO;
import com.ecommerce.exception.AbstractException;
import org.hibernate.query.Page;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface SaleService {
    public Optional<Double> getTotalSaleAmountForToday() throws AbstractException;
    public Optional<LocalDate> getMaxSaleDay(LocalDate startDate, LocalDate endDate) throws AbstractException ;
    public List<TopSellingItemDTO> getTopSellingItemsOfAllTime() throws AbstractException;
    public List<TopSellingItemDTO> getTopSellingItemsOfLastMonth() throws AbstractException;
}
