package com.wanted.challenge.Service.product;

import com.wanted.challenge.Service.product.command.ProductCategoryCommand;
import com.wanted.challenge.Service.product.command.ProductImageCommand;
import com.wanted.challenge.Service.product.command.ProductOptionCommand;
import com.wanted.challenge.Service.product.command.ProductSaveCommand;
import com.wanted.challenge.Service.product.info.ProductSaveInfo;
import com.wanted.challenge.domain.product.*;
import com.wanted.challenge.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public ProductSaveInfo saveProduct(ProductSaveCommand command) {
        Product product = command.toDomain();
        productRepository.save(product);
        return ProductSaveInfo.toInfo(product);
    }
}
