package com.pradhan.inventory.dto;

import java.time.LocalDate;

public record InventoryBatchResponse(
        Long batchId,
        Long productId,
        String productName,
        int quantity,
        LocalDate expiryDate) {}