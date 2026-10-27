package com.pradhan.inventory.dto;

import java.util.List;

public record InventoryUpdateResponse(
        Long productId,
        String productName,
        int quantityReserved,
        List<Long> reservedBatchIds,
        String message) {}
