package com.ecom.service;

import com.ecom.InventoryForProductUpdate;
import com.ecom.common.Constants;
import com.ecom.dto.ProductRequest;
import com.ecom.entity.Product;
import com.ecom.repos.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final KafkaTemplate<String, InventoryForProductUpdate> kafkaTemplate;
    private static int skuCodeCounter = 0;
    public void createProduct(ProductRequest productRequest) {
        productRequest.setSkuCode(productRequest.getSkuCode() + "" + skuCodeCounter);
        Product product = Product.builder()
                .name(productRequest.getName())
                .skuCode(productRequest.getDescription())
                .price(productRequest.getPrice())
                .skuCode(productRequest.getSkuCode())
                .quantity(productRequest.getQuantity())
                .build();
        log.debug("saving product {} to productRepository", product);
        productRepository.save(product);
        log.debug("Publishing event to kafka topic", product);
        kafkaTemplate.send(Constants.TOPIC_PRODUCT_ADD, new InventoryForProductUpdate(productRequest.getSkuCode()
                , productRequest.getQuantity(), Constants.PRODUCT_ADDED));
        log.info("Product with id {} is saved successfully", product.getId());
    }
}
