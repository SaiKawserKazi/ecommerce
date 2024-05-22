package com.ecommerce.service;

import com.ecommerce.entity.Wishlist;
import com.ecommerce.repository.WishlistRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class WishlistServiceImpl implements WishlistService{

    private final WishlistRepository wishlistRepository;

    public WishlistServiceImpl(WishlistRepository wishlistRepository) {
        this.wishlistRepository = wishlistRepository;
    }

    public List<Wishlist> getWishlistByCustomerId(UUID customerId) {
        return wishlistRepository.findByCustomerCustomerId(customerId);
    }
}
