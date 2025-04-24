package com.wanted.challenge.controller.product.response;

import com.wanted.challenge.Service.product.info.ProductSaveInfo;

import java.time.LocalDateTime;

public record ProductCreateResponse(
        long id,
        String name,
        String slug,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static ProductCreateResponse toResponse(ProductSaveInfo info) {
        return new ProductCreateResponse(
                info.id(),
                info.name(),
                info.slug(),
                info.createdAt(),
                info.updatedAt()
        );
    }
}
