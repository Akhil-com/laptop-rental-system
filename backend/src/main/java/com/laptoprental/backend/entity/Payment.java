package com.laptoprental.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Rental rental;
    @ManyToOne
    private User user;

    private Double amount;
    private String paymentMethod; // e.g., Razorpay, UPI
    private String status;  // SUCCESS, FAILED, PENDING

    private LocalDateTime paymentDate;

    // getters and setters
}