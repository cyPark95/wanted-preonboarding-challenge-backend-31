package com.wanted.challenge.controller.product.request;

import com.wanted.challenge.Service.product.command.ProductSaveCommand;
import com.wanted.challenge.domain.product.ProductStatus;

import java.util.List;

public record ProductCreateRequest(
        String name,
        String slug,
        String shortDescription,
        String fullDescription,
        long sellerId,
        long brandId,
        String status,
        ProductDetailRequest detail,
        ProductPriceRequest price,
        List<ProductCategoryRequest> categories,
        List<ProductOptionGroupRequest> optionGroups,
        List<ProductImageRequest> images,
        List<Long> tags
) {

    public ProductSaveCommand toCommand() {
        return new ProductSaveCommand(
                this.name,
                this.slug,
                this.shortDescription,
                this.fullDescription,
                this.sellerId,
                this.brandId,
                ProductStatus.valueOf(this.status),
                this.detail.toCommand(),
                this.price.toCommand(),
                this.categories.stream()
                        .map(ProductCategoryRequest::toCommand)
                        .toList(),
                this.optionGroups.stream()
                        .map(ProductOptionGroupRequest::toCommand)
                        .toList(),
                this.images.stream()
                        .map(ProductImageRequest::toCommand)
                        .toList(),
                this.tags
        );
    }
}
