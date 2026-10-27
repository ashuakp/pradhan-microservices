package com.pradhan.inventory.factory;

import com.pradhan.inventory.entity.InventoryBatch;

import java.util.ArrayList;
import java.util.List;

public class FefoInventoryAllocationStrategy implements InventoryAllocationStrategy {

    @Override
    public List<BatchAllocation> allocate(List<InventoryBatch> batches, int requestedQuantity) {

        int remaining = requestedQuantity;
        List<BatchAllocation> result = new ArrayList<>();

        for(InventoryBatch batch : batches){

            if(remaining == 0){
                break;
            }

            if(batch.getQuantity() <= 0){
                continue;
            }
            int amount = Math.min(batch.getQuantity(), remaining);
            result.add(new BatchAllocation(batch, amount));
            remaining -= amount;
        }

        if(remaining >= 0){
            throw new InsufficientInventoryException("Insufficient stock for the requested quantity");
        }

        return result;
    }

    public static class InsufficientInventoryException extends RuntimeException {
        public InsufficientInventoryException(String message) {
            super(message);
        }
    }
}
