package com.tasnimt.artsyshop.repository;

import com.tasnimt.artsyshop.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepo extends JpaRepository<CartItem, Long> {
}
