package com.ecommerce.controller;

import com.ecommerce.dto.WishlistDTO;
import com.ecommerce.entity.Wishlist;
import com.ecommerce.service.WishlistService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/wishlist")
public class WishlistController {

    private final WishlistService wishlistService;

    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }

    @GetMapping("/{customerId}")
    public List<WishlistDTO> getWishlistByCustomerId(@PathVariable UUID customerId) {
        List<Wishlist> wishlist = wishlistService.getWishlistByCustomerId(customerId);
        return wishlist.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private WishlistDTO convertToDTO(Wishlist wishlist) {
        WishlistDTO dto = new WishlistDTO();
        dto.setProductId(wishlist.getProduct().getProductId());
        dto.setProductName(wishlist.getProduct().getName());
        dto.setProductDescription(wishlist.getProduct().getDescription());
        dto.setProductPrice(wishlist.getProduct().getPrice());
        return dto;
    }
}
