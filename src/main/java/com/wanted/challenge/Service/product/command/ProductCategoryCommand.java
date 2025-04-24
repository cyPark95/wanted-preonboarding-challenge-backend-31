package com.wanted.challenge.Service.product.command;

import com.wanted.challenge.domain.product.ProductCategory;

public record ProductCategoryCommand(
        long categoryId,
        boolean isPrimary
) {
    public ProductCategory toDomain() {
        return ProductCategory.builder()
                .categoryId(this.categoryId)
                .isPrimary(this.isPrimary)
                .build();
    }
}
