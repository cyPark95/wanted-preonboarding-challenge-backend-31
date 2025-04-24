package com.wanted.challenge.controller.product.request;

import com.wanted.challenge.Service.product.command.ProductDetailCommand;

import java.util.Map;

public record ProductDetailRequest(
        Double weight,
        Map<String, Object> dimensions,
        String materials,
        String countryOfOrigin,
        String warrantyInfo,
        String careInstructions,
        Map<String, Object> additionalInfo
) {

    public ProductDetailCommand toCommand() {
        return new ProductDetailCommand(
                this.weight,
                this.dimensions,
                this.materials,
                this.countryOfOrigin,
                this.warrantyInfo,
                this.careInstructions,
                this.additionalInfo
        );
    }
}
