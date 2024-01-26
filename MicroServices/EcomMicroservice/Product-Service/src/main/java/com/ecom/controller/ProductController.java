package com.ecom.controller;

import com.ecom.dto.ProductRequest;
import com.ecom.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
@Validated
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public void createProduct(@RequestBody @Valid ProductRequest productRequest) {
        productService.createProduct(productRequest);
    }


}
