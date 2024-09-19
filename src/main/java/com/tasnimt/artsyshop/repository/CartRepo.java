package com.tasnimt.artsyshop.repository;

import com.tasnimt.artsyshop.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Cart, Long> {

}
