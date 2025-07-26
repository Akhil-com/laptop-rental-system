package com.laptoprental.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "rentals")
@Data
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Laptop laptop;

    private String rentalType; // DAILY or MONTHLY
    private LocalDate startDate;
    private LocalDate endDate;

    private String status; // ACTIVE, COMPLETED, CANCELLED
    @OneToOne(mappedBy = "rental", cascade = CascadeType.ALL)
    private Invoice invoice;

    @OneToOne(mappedBy = "rental", cascade = CascadeType.ALL)
    private Payment payment;
    // getters and setters
}
