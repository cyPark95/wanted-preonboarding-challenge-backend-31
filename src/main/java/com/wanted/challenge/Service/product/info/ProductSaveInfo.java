package com.wanted.challenge.Service.product.info;

import com.wanted.challenge.domain.product.Product;

import java.time.LocalDateTime;

public record ProductSaveInfo(
        long id,
        String name,
        String slug,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static ProductSaveInfo toInfo(Product product) {
        return new ProductSaveInfo(
                product.getId(),
                product.getName(),
                product.getSlug(),
                product.getCreatedAt(),
                product.getUpdatedAt()
        );
    }
}
