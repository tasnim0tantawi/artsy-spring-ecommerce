package com.tasnimt.artsyshop.service.product;

import com.tasnimt.artsyshop.model.Product;
import com.tasnimt.artsyshop.request.product.StoreProductRequest;
import com.tasnimt.artsyshop.request.product.UpdateProductRequest;

import java.util.List;

public interface IProductService {
    Product addProduct(StoreProductRequest product);
    Product getProduct(Long id);
    void deleteProduct(Long id);
    Product updateProduct(UpdateProductRequest product, Long productId);
    List<Product> getAllProducts();
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByBrand(String brand);
    List<Product> getProductsByCategoryAndBrand(String category, String brand);
    List<Product> getProductsByName(String name);
    List<Product> getProductsByBrandAndName(String category, String name);
    Long countProductsByBrandAndName(String brand, String name);

}
