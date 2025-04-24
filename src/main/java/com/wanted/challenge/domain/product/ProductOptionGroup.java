package com.wanted.challenge.domain.product;

import com.wanted.challenge.common.exception.InvalidInputException;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product_option_groups")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductOptionGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "display_order", nullable = false)
    private int displayOrder;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductOption> options = new ArrayList<>();

    @Builder
    public ProductOptionGroup(String name, int displayOrder, List<ProductOption> options) {
        if(name == null) {
            throw new InvalidInputException("Product option group name cannot be null");
        }

        this.name = name;
        this.displayOrder = displayOrder;
        this.options = options;
    }
}
