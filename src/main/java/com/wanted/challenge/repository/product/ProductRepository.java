package com.wanted.challenge.repository.product;

import com.wanted.challenge.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
