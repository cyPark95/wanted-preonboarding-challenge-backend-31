package com.wanted.challenge.controller.product;

import com.wanted.challenge.Service.product.command.ProductSaveCommand;
import com.wanted.challenge.Service.product.info.ProductSaveInfo;
import com.wanted.challenge.common.response.ApiResponse;
import com.wanted.challenge.Service.product.ProductService;
import com.wanted.challenge.controller.product.request.ProductCreateRequest;
import com.wanted.challenge.controller.product.response.ProductCreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/api/products")
    public ResponseEntity<ApiResponse<ProductCreateResponse>> createProduct(@RequestBody ProductCreateRequest request) {
        ProductSaveCommand command = request.toCommand();
        ProductSaveInfo info = productService.saveProduct(command);
        ProductCreateResponse response = ProductCreateResponse.toResponse(info);
        return new ResponseEntity<>(ApiResponse.success(response, "상품이 성공적으로 등록되었습니다."), HttpStatus.CREATED);
    }
}
