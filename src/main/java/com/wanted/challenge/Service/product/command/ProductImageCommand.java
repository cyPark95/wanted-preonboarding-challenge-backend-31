package com.wanted.challenge.Service.product.command;

import com.wanted.challenge.domain.product.ProductImage;

public record ProductImageCommand(
        String url,
        String altText,
        Boolean isPrimary,
        Integer displayOrder,
        Long optionId
) {

    public ProductImage toDomain() {
        return ProductImage.builder()
                .url(this.url)
                .altText(this.altText)
                .isPrimary(this.isPrimary)
                .displayOrder(this.displayOrder)
                .build();
    }
}
