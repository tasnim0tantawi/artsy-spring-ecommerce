package com.tasnimt.artsyshop.controller;

import com.tasnimt.artsyshop.response.ApiResponse;
import com.tasnimt.artsyshop.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/")
    public ResponseEntity<ApiResponse> getAllProducts() {
        return null;
    }
}
