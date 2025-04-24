package com.wanted.challenge.domain.product;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_categories")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "category_id", nullable = false)
    private long categoryId;

    @Column(name = "is_primary", nullable = false)
    private boolean isPrimary;

    @Builder
    public ProductCategory(long categoryId, boolean isPrimary) {
        this.categoryId = categoryId;
        this.isPrimary = isPrimary;
    }
}
