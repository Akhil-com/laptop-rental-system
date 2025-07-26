package com.laptoprental.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class RentedLaptop {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Laptop laptop;

    private int quantity;
    private double rentalPrice; // calculated for this laptop * quantity
}
