package com.tasnimt.artsyshop.service.product;

import com.tasnimt.artsyshop.exception.ResourceNotFoundException;
import com.tasnimt.artsyshop.model.Category;
import com.tasnimt.artsyshop.model.Product;
import com.tasnimt.artsyshop.repository.CategoryRepo;
import com.tasnimt.artsyshop.repository.ImageRepo;
import com.tasnimt.artsyshop.repository.ProductRepo;
import com.tasnimt.artsyshop.request.product.StoreProductRequest;
import com.tasnimt.artsyshop.request.product.UpdateProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
    private final ProductRepo productRepo;
    private final CategoryRepo categoryRepo;
    private final ImageRepo imageRepo;

    @Override
    public Product addProduct(StoreProductRequest request) {
        Category category = Optional.ofNullable(categoryRepo.findByName(request.getCategory().getName()))
                .orElseGet(()->{
                    Category newCategory = new Category(request.getCategory().getName());
                    return categoryRepo.save(newCategory);
                });
        request.setCategory(category);

        return productRepo.save(new Product(request.getName(), request.getDescription(), request.getPrice(), request.getBrand(), request.getInventory(), category));
    }

    @Override
    public Product getProduct(Long id) {
        return productRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Product not found"));
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return productRepo.findByName(name);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepo.findById(id).ifPresentOrElse(productRepo::delete, ()->{
            throw new ResourceNotFoundException("Product not found");
        });

    }

    @Override
    public Product updateProduct(UpdateProductRequest product, Long productId) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public List<Product> getProductsByCategory(String categoryName) {
        return productRepo.findByCategoryName(categoryName);
    }

    @Override
    public List<Product> getProductsByBrand(String brandName) {
        return productRepo.findByBrand(brandName);
    }

    @Override
    public List<Product> getProductsByCategoryAndBrand(String categoryName, String brandName) {
        return productRepo.findByCategoryNameAndBrand(categoryName, brandName);
    }

    @Override
    public Long countProductsByBrandAndName(String brandName, String name) {
        return productRepo.countByBrandAndName(brandName, name);
    }

    @Override
    public List<Product> getProductsByBrandAndName(String brandName, String name) {
        return productRepo.findByBrandAndName(brandName, name);
    }

}
