package com.wanted.challenge.Service.product.command;

import com.wanted.challenge.domain.product.ProductDetail;

import java.util.Map;

public record ProductDetailCommand(
        Double weight,
        Map<String, Object> dimensions,
        String materials,
        String countryOfOrigin,
        String warrantyInfo,
        String careInstructions,
        Map<String, Object> additionalInfo
) {

    public ProductDetail toDomain() {
        return ProductDetail.builder()
                .weight(this.weight)
                .dimensions(this.dimensions)
                .materials(this.materials)
                .countryOfOrigin(this.countryOfOrigin)
                .warrantyInfo(this.warrantyInfo)
                .careInstructions(this.careInstructions)
                .additionalInfo(this.additionalInfo)
                .build();
    }
}
