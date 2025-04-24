package com.wanted.challenge.Service.product.command;

import com.wanted.challenge.domain.product.ProductOption;

import java.math.BigDecimal;

public record ProductOptionCommand(
        String name,
        BigDecimal additionalPrice,
        String sku,
        Integer stock,
        Integer displayOrder
) {

    public ProductOption toDomain() {
        return ProductOption.builder()
                .name(this.name)
                .additionalPrice(this.additionalPrice)
                .sku(this.sku)
                .stock(this.stock)
                .displayOrder(this.displayOrder)
                .build();
    }
}
