package com.ecommerce.service;

import com.ecommerce.entity.Wishlist;

import java.util.List;
import java.util.UUID;

public interface WishlistService {
    public List<Wishlist> getWishlistByCustomerId(UUID customerId);
}
