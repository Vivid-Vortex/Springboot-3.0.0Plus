package com.cach.controller;

import com.cach.dto.ProductRequest;
import com.cach.dto.ProductResponse;
import com.cach.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@Validated
@RequiredArgsConstructor
public class CacheController {
    private final ProductService productService;

    @GetMapping
    @ResponseStatus
    public void createProduct(@RequestBody @Valid ProductRequest productRequest) {
        productService.createProduct(productRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllproducts() {
        productService.getAllproducts()
    }
}
