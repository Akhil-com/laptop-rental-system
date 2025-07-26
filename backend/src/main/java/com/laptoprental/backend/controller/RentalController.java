package com.laptoprental.backend.controller;

import com.laptoprental.backend.entity.Rental;
import com.laptoprental.backend.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @PostMapping("/checkout")
    public ResponseEntity<Rental> checkout(
            @RequestParam Long userId,
            @RequestParam String rentalType) {

        Rental rental = rentalService.checkout(userId, rentalType);
        return ResponseEntity.ok(rental);
    }
}