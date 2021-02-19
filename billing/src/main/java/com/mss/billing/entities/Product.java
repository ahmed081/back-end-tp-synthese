package com.mss.billing.entities;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private String description;
    private double price;
    private int quantity;
}
