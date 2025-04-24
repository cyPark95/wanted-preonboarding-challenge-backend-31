package com.wanted.challenge.domain.product;

import com.wanted.challenge.common.exception.InvalidInputException;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "product_prices")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProductPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "base_price", nullable = false, precision = 12, scale = 2)
    private BigDecimal basePrice;

    @Column(name = "sale_price", precision = 12, scale = 2)
    private BigDecimal salePrice;

    @Column(name = "cost_price", precision = 12, scale = 2)
    private BigDecimal costPrice;

    @Column(length = 3, nullable = false)
    @ColumnDefault("'KRW'")
    private String currency;

    @Column(name = "tax_rate", precision = 5, scale = 2)
    private BigDecimal taxRate;

    @Builder
    private ProductPrice(BigDecimal basePrice, BigDecimal salePrice, BigDecimal costPrice, String currency, BigDecimal taxRate) {
        if(basePrice == null) {
            throw new InvalidInputException("Base price cannot be null");
        }

        this.basePrice = basePrice;
        this.salePrice = salePrice;
        this.costPrice = costPrice;
        this.currency = Objects.requireNonNullElse(currency, "KRW");
        this.taxRate = taxRate;
    }
}
