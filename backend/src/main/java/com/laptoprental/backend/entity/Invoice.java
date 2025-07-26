package com.laptoprental.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "invoices")
@Data
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Rental rental;

    private LocalDate generatedDate;
    private double Amount;

    private String filePath;

    // getters and setters
}
