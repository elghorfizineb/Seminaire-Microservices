package org.billing.billingservice.models;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private String nom;
    private double quantity;
    private double price;
}
