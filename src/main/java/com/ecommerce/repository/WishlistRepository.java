package com.ecommerce.repository;

import com.ecommerce.entity.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
import java.util.List;

public interface WishlistRepository extends JpaRepository<Wishlist, UUID> {
    List<Wishlist> findByCustomerCustomerId(UUID customerId);
}
