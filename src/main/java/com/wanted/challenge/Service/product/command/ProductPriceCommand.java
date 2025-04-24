package com.wanted.challenge.Service.product.command;

import com.wanted.challenge.domain.product.ProductPrice;

import java.math.BigDecimal;

public record ProductPriceCommand(
        BigDecimal basePrice,
        BigDecimal salePrice,
        BigDecimal costPrice,
        String currency,
        BigDecimal taxRate
) {

    public ProductPrice toDomain() {
        return ProductPrice.builder()
                .basePrice(this.basePrice)
                .salePrice(this.salePrice)
                .costPrice(this.costPrice)
                .currency(this.currency)
                .taxRate(this.taxRate)
                .build();
    }
}
