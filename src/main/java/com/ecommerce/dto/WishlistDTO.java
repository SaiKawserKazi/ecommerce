package com.ecommerce.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WishlistDTO {
    private UUID productId;
    private String productName;
    private String productDescription;
    private Double productPrice;
}
