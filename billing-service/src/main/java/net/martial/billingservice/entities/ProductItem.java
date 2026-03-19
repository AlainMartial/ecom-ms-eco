package net.martial.billingservice.entities;

import jakarta.persistence.*;
import net.martial.billingservice.model.Product;

@Entity
public class ProductItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productId;
    @ManyToOne
    private Bill bill;
    private int quantity;
    private double unitPrice;
    @Transient
    private Product product;
}
