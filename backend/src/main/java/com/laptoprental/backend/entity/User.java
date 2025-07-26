package com.laptoprental.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Long id;

    private String username;
    private String password;
    private String email;
    private String role;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Cart cart;

    @OneToMany(mappedBy = "user")
    private List<Rental> rentals;

    @OneToMany(mappedBy = "user")
    private List<Payment> payments;
    // USER or ADMIN

    // getters and setters
}
