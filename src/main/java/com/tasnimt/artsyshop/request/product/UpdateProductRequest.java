package com.tasnimt.artsyshop.request.product;

import com.tasnimt.artsyshop.model.Category;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateProductRequest {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String brand;
    private int inventory;
    private Category category;
}
