package com.wanted.challenge.domain.product;

import com.wanted.challenge.common.exception.InvalidInputException;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product_options")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductOption {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "additional_price", precision = 12, scale = 2)
    private BigDecimal additionalPrice;

    @Column(nullable = false, unique = true)
    private String sku;

    @Column(nullable = false)
    private int stock;

    @Column(name = "display_order", nullable = false)
    private int displayOrder;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "option_id")
    private List<ProductImage> images = new ArrayList<>();

    @Builder
    public ProductOption(String name, BigDecimal additionalPrice, String sku, int stock, int displayOrder, List<ProductImage> images) {
        if(sku == null) {
            throw new InvalidInputException("Stock Keeping Unit cannot be null");
        }

        this.name = name;
        this.additionalPrice = additionalPrice;
        this.sku = sku;
        this.stock = stock;
        this.displayOrder = displayOrder;
        this.images = images;
    }
}
