package com.laptoprental.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "laptops")
@Data
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String brand;
    private String model;
    private Double pricePerDay;
    private boolean available;
    private String specs;
    private String imageUrl;

    @OneToMany(mappedBy = "laptop")
    private List<Cartitem> cartItems;

    @OneToMany(mappedBy = "laptop")
    private List<Rental> rentals;
    // getters and setters
}