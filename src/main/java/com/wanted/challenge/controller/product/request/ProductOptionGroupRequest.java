package com.wanted.challenge.controller.product.request;

import com.wanted.challenge.Service.product.command.ProductOptionGroupCommand;

import java.util.List;

public record ProductOptionGroupRequest(
        String name,
        Integer displayOrder,
        List<ProductOptionRequest> options
) {

    public ProductOptionGroupCommand toCommand() {
        return new ProductOptionGroupCommand(
                this.name,
                this.displayOrder,
                this.options.stream()
                        .map(ProductOptionRequest::toCommand)
                        .toList()
        );
    }
}
