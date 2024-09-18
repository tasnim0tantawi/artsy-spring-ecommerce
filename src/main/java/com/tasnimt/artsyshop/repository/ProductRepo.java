package com.tasnimt.artsyshop.repository;

import com.tasnimt.artsyshop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findByCategoryName(String categoryName);

    List<Product> findByName(String name);

    List<Product> findByBrand(String brandName);

    List<Product> findByCategoryNameAndBrand(String categoryName, String brandName);

    Long countByBrandAndName(String brandName, String name);

    List<Product> findByBrandAndName(String brandName, String name);
}
