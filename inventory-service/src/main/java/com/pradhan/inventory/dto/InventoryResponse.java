package com.pradhan.inventory.dto;

import java.util.List;

public record InventoryResponse(
        Long productId,
        String productName,
        List<InventoryBatchResponse> batches) {}
