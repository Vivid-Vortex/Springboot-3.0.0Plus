package com.ecom.dto;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

    @NotBlank(message = "Name is required")
    @Size(max = 500, message = "Name must be between 3 and 100 characters")
    private String name;

    @NotBlank(message = "Description is required")
    @Size(max = 500, message = "Description cannot exceed 500 characters")  // max 500 characters for description field
    private String description;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    private Double price;

    //From inventory service call
    @NotNull(message = "ProductId is required")
    @Min(value = 1, message = "ProductId must be greater than or equal to 1")
    private Integer productId;

    @NotBlank(message = "SkuCode is required")
    @Size(min = 5, max = 20, message = "SkuCode msut be between 5 and 20")
    private String skuCode;

    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity must be greater than or equal to 1")  // min 1 quantity for each product.
    private Integer quantity;
}
