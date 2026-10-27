package com.pradhan.inventory.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "inventory_batch")
public class InventoryBatch {

    @Id
    private Long id;

    @Column(name = "product_id", nullable = false)
    private Long productId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(nullable = false)
    private int quantity;

    @Column(name = "expiry_date", nullable = false)
    private LocalDate expiryDate;

    protected InventoryBatch() {}

    public Long getId() { return id; }
    public Long getProductId() { return productId; }
    public String getProductName() { return productName; }
    public int getQuantity() { return quantity; }
    public LocalDate getExpiryDate() { return expiryDate; }

    public void reduceQuantity(int amount) {
        if(amount <= 0 || amount > quantity){
            throw new IllegalArgumentException("Invalid quantity");
        }
        quantity -= amount;
    }
}