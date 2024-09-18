package com.tasnimt.artsyshop.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartItemDto {
    private Long id;
    private BigDecimal unitPrice;
    private Integer quantity;
    private ProductDto product;
}
