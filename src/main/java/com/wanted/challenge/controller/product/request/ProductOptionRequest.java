package com.wanted.challenge.controller.product.request;

import com.wanted.challenge.Service.product.command.ProductOptionCommand;

import java.math.BigDecimal;

public record ProductOptionRequest(
        String name,
        BigDecimal additionalPrice,
        String sku,
        Integer stock,
        Integer displayOrder
) {

    public ProductOptionCommand toCommand() {
        return new ProductOptionCommand(
                this.name,
                this.additionalPrice,
                this.sku,
                this.stock,
                this.displayOrder
        );
    }
}
