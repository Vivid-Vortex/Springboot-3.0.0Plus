package com.ecom;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InventoryForProductUpdate {
    private String skuCode;
    private Integer quantity;
    private String actionType;
}
