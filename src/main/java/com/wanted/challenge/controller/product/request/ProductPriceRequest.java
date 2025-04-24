package com.wanted.challenge.controller.product.request;

import com.wanted.challenge.Service.product.command.ProductPriceCommand;

import java.math.BigDecimal;

public record ProductPriceRequest(
        BigDecimal basePrice,
        BigDecimal salePrice,
        BigDecimal costPrice,
        String currency,
        BigDecimal taxRate
) {

    public ProductPriceCommand toCommand() {
        return new ProductPriceCommand(
                this.basePrice,
                this.salePrice,
                this.costPrice,
                this.currency,
                this.taxRate
        );
    }
}
