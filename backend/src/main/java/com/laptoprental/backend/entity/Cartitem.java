package com.laptoprental.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "cart_items")
@Data
public class Cartitem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cart cart;

    @ManyToOne
    private Laptop laptop;

    private int quantity;
    private String rentalType; // DAILY or MONTHLY

    // getters and setters
}