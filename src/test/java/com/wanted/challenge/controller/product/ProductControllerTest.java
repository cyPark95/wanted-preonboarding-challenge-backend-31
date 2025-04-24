package com.wanted.challenge.controller.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wanted.challenge.controller.product.request.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("상품 Controller 통합 테스트")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @DisplayName("상품 등록")
    @Test
    void createProduct() throws Exception {
        // given
        ProductCreateRequest request = getProductCreateRequest();

        // when
        // then
        mockMvc.perform(post("/api/products")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.success").value(true))
                .andExpect(jsonPath("$.message").value("상품이 성공적으로 등록되었습니다."))
                .andExpect(jsonPath("$.data.id").exists())
                .andExpect(jsonPath("$.data.name").value("슈퍼 편안한 소파"))
                .andExpect(jsonPath("$.data.slug").value("super-comfortable-sofa"))
                .andExpect(jsonPath("$.data.created_at").exists())
                .andExpect(jsonPath("$.data.updated_at").exists());
    }

    private ProductCreateRequest getProductCreateRequest() {
        return new ProductCreateRequest(
                "슈퍼 편안한 소파",
                "super-comfortable-sofa",
                "최고급 소재로 만든 편안한 소파",
                "<p>이 소파는 최고급 소재로 제작되었으며...</p>",
                1L,
                2L,
                "ACTIVE",
                new ProductDetailRequest(
                        25.5,
                        Map.of(
                                "width", 200,
                                "height", 85,
                                "depth", 90
                        ),
                        "가죽, 목재, 폼",
                        "대한민국",
                        "2년 품질 보증",
                        "마른 천으로 표면을 닦아주세요",
                        Map.of(
                                "assembly_required", true,
                                "assembly_time", "30분"
                        )
                ),
                new ProductPriceRequest(
                        new BigDecimal("599000"),
                        new BigDecimal("499000"),
                        new BigDecimal("350000"),
                        "KRW",
                        new BigDecimal("10")
                ),
                List.of(
                        new ProductCategoryRequest(5L, true),
                        new ProductCategoryRequest(8L, false)
                ),
                List.of(
                        new ProductOptionGroupRequest(
                                "색상",
                                1,
                                List.of(
                                        new ProductOptionRequest(
                                                "브라운",
                                                new BigDecimal("0"),
                                                "SOFA-BRN",
                                                10,
                                                1
                                        ),
                                        new ProductOptionRequest(
                                                "블랙",
                                                new BigDecimal("0"),
                                                "SOFA-BLK",
                                                15,
                                                2
                                        )
                                )
                        ),
                        new ProductOptionGroupRequest(
                                "소재",
                                2,
                                List.of(
                                        new ProductOptionRequest(
                                                "천연 가죽",
                                                new BigDecimal("100000"),
                                                "SOFA-LTHR",
                                                5,
                                                1
                                        ),
                                        new ProductOptionRequest(
                                                "인조 가죽",
                                                new BigDecimal("0"),
                                                "SOFA-FAKE",
                                                20,
                                                2
                                        )
                                )
                        )
                ),
                List.of(
                        new ProductImageRequest(
                                "https://example.com/images/sofa1.jpg",
                                "브라운 소파 정면",
                                true,
                                1,
                                null
                        ),
                        new ProductImageRequest(
                                "https://example.com/images/sofa2.jpg",
                                "브라운 소파 측면",
                                false,
                                2,
                                null
                        )
                ),
                List.of(1L, 4L, 7L)
        );
    }
}
