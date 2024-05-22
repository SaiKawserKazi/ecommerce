package com.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor

public class TopSellingItemDTO {
    private UUID productId;
    private String productName;
    private Long totalSales;

//    public TopSellingItemDTO(UUID productId, String productName, Long totalSales) {
//        this.productId = productId;
//        this.productName = productName;
//        this.totalSales = totalSales != null ? totalSales.longValue() : 0L;
//    }
}
