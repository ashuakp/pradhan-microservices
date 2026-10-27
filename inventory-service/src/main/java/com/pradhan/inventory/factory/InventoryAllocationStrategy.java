package com.pradhan.inventory.factory;

import com.pradhan.inventory.entity.InventoryBatch;

import java.util.List;

public interface InventoryAllocationStrategy {

    List<BatchAllocation> allocate(
            List<InventoryBatch> batches,
            int requestedQuantity);

    record BatchAllocation(InventoryBatch batch, int quantity) {}
}
