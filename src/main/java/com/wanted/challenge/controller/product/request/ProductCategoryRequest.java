package com.wanted.challenge.controller.product.request;

import com.wanted.challenge.Service.product.command.ProductCategoryCommand;

public record ProductCategoryRequest(
        long categoryId,
        boolean isPrimary
) {

    public ProductCategoryCommand toCommand() {
        return new ProductCategoryCommand(
                this.categoryId,
                this.isPrimary
        );
    }
}
