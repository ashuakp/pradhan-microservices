package com.pradhan.inventory.dto;

public record InventoryUpdateRequest(Long productId, Integer quantity) {
}
