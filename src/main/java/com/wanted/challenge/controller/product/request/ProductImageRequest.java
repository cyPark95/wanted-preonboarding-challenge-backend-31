package com.wanted.challenge.controller.product.request;

import com.wanted.challenge.Service.product.command.ProductImageCommand;

public record ProductImageRequest(
        String url,
        String altText,
        Boolean isPrimary,
        Integer displayOrder,
        Long optionId
) {

    public ProductImageCommand toCommand() {
        return new ProductImageCommand(
                this.url,
                this.altText,
                this.isPrimary,
                this.displayOrder,
                this.optionId
        );
    }
}
