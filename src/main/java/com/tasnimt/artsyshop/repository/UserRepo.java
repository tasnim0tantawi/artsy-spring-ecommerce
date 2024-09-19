package com.tasnimt.artsyshop.repository;

import com.tasnimt.artsyshop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
