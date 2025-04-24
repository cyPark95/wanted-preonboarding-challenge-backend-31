package com.wanted.challenge.Service.product.command;

import com.wanted.challenge.domain.product.ProductOption;
import com.wanted.challenge.domain.product.ProductOptionGroup;

import java.util.List;

public record ProductOptionGroupCommand(
        String name,
        Integer displayOrder,
        List<ProductOptionCommand> options
) {

    public ProductOptionGroup toDomain(List<ProductOption> productOptions) {
        return ProductOptionGroup.builder()
                .name(this.name)
                .displayOrder(this.displayOrder)
                .options(productOptions)
                .build();
    }
}
