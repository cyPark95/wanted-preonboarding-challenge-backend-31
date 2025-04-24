package com.wanted.challenge.domain.product;


import com.wanted.challenge.common.entity.BaseTimeEntity;
import com.wanted.challenge.common.exception.InvalidInputException;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String slug;

    @Column(name = "short_description", length = 500)
    private String shortDescription;

    @Column(name = "full_description", columnDefinition = "TEXT")
    private String fullDescription;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProductStatus status;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private ProductDetail detail;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private ProductPrice price;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "product_id")
    private List<ProductOptionGroup> optionGroups = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "product_id")
    private List<ProductImage> images = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "product_id")
    private List<ProductCategory> categories = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "product_id")
    private List<ProductTag> tags = new ArrayList<>();

    @Builder
    public Product(String name, String slug, String shortDescription, String fullDescription, ProductStatus status, ProductDetail detail, ProductPrice price, List<ProductOptionGroup> optionGroups, List<ProductImage> images, List<ProductCategory> categories, List<ProductTag> tags) {
        if(name == null) {
            throw new InvalidInputException("Product name cannot be null");
        }

        if(slug == null) {
            throw new InvalidInputException("Product slug cannot be null");
        }

        if(status == null) {
            throw new InvalidInputException("Product status cannot be null");
        }

        this.name = name;
        this.slug = slug;
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.status = status;
        this.detail = detail;
        this.price = price;
        this.optionGroups = optionGroups;
        this.images = images;
        this.categories = categories;
        this.tags = tags;
    }
}
