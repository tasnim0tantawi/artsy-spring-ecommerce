package com.tasnimt.artsyshop.repository;

import com.tasnimt.artsyshop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
    Category findByName(String name);
    boolean existsByName(String name);
}
