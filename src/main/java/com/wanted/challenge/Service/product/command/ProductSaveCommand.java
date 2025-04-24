package com.wanted.challenge.Service.product.command;

import com.wanted.challenge.domain.product.*;

import java.util.List;

public record ProductSaveCommand(
        String name,
        String slug,
        String shortDescription,
        String fullDescription,
        long sellerId,
        long brandId,
        ProductStatus status,
        ProductDetailCommand detail,
        ProductPriceCommand price,
        List<ProductCategoryCommand> categories,
        List<ProductOptionGroupCommand> optionGroups,
        List<ProductImageCommand> images,
        List<Long> tags
) {

    public Product toDomain() {
        ProductDetail productDetail = this.detail.toDomain();
        ProductPrice productPrice = price().toDomain();
        List<ProductCategory> productCategories = getProductCategories();
        List<ProductOptionGroup> productOptionGroups = getProductOptionGroups();
        List<ProductImage> productImages = getProductImages();
        List<ProductTag> productTags = getProductTags();

        return Product.builder()
                .name(name())
                .slug(slug())
                .shortDescription(shortDescription())
                .fullDescription(fullDescription())
                .status(status())
                .detail(productDetail)
                .price(productPrice)
                .optionGroups(productOptionGroups)
                .images(productImages)
                .categories(productCategories)
                .tags(productTags)
                .build();
    }

    private List<ProductCategory> getProductCategories() {
        return this.categories.stream()
                .map(ProductCategoryCommand::toDomain)
                .toList();
    }

    private List<ProductOptionGroup> getProductOptionGroups() {
        return this.optionGroups.stream()
                .map(command -> {
                    List<ProductOption> productOptions = getProductOptions(command);
                    return command.toDomain(productOptions);
                })
                .toList();
    }

    private static List<ProductOption> getProductOptions(ProductOptionGroupCommand command) {
        return command.options().stream()
                .map(ProductOptionCommand::toDomain)
                .toList();
    }

    private List<ProductImage> getProductImages() {
        return this.images.stream()
                .map(ProductImageCommand::toDomain)
                .toList();
    }

    private List<ProductTag> getProductTags() {
        return this.tags.stream()
                .map(ProductTag::new)
                .toList();
    }
}
