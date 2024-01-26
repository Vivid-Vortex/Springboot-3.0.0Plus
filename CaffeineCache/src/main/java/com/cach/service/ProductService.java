package com.cach.service;

import com.cach.InventoryForProductUpdate;
import com.cach.dto.ProductRequest;
import com.cach.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    Faker faker = new Faker();
    private static int skuCodeCounter = 0;
    public ProductRequest createProduct(ProductRequest productRequest) {
       log.info("createProduct being called");
        return productRequest;
    }

    public ProductResponse getAllproducts() {

    }
}
