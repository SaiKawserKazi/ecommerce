package com.ecommerce.service;

import com.ecommerce.entity.Wishlist;
import com.ecommerce.exception.AbstractException;

import java.util.List;
import java.util.UUID;

public interface WishlistService {
    public List<Wishlist> getWishlistByCustomerId(UUID customerId) throws AbstractException;
}
