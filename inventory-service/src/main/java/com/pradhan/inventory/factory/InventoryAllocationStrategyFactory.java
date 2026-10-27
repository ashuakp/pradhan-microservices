package com.pradhan.inventory.factory;

public class InventoryAllocationStrategyFactory {

    public InventoryAllocationStrategy getStrategy() {
        return new FefoInventoryAllocationStrategy();
    }
}
