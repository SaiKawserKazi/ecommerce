package com.ecommerce.controller;

import com.ecommerce.dto.TopSellingItemDTO;
import com.ecommerce.service.SaleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping("/total-today")
    public double getTotalSaleAmountForToday() {
        Optional<Double> totalAmount = saleService.getTotalSaleAmountForToday();
        return totalAmount.orElse(0.0);
    }

    @GetMapping("/max-sale-day")
    public LocalDate getMaxSaleDay(@RequestParam("startDate") LocalDate startDate, @RequestParam("endDate") LocalDate endDate) {
        Optional<LocalDate> maxSaleDay = saleService.getMaxSaleDay(startDate, endDate);
        return maxSaleDay.orElse(null);
    }

    @GetMapping("/top-selling-items")
    public List<TopSellingItemDTO> getTopSellingItemsOfAllTime() {
        return saleService.getTopSellingItemsOfAllTime();
    }

    @GetMapping("/top-selling-items-last-month")
    public List<TopSellingItemDTO> getTopSellingItemsOfLastMonth() {
        return saleService.getTopSellingItemsOfLastMonth();
    }
}
