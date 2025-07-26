package com.laptoprental.backend.service;

import com.laptoprental.backend.entity.Rental;
import com.laptoprental.backend.repositories.LaptopRepository;
import com.laptoprental.backend.repositories.RentalRepository;
import com.laptoprental.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {
    @Autowired
    private RentalRepository rentalRepository;
    @Autowired
    private CartService cartService;

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private LaptopRepository laptopRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Rental> findAll() {
        return rentalRepository.findAll();
    }

    public List<Rental> findByUserId(Long userId) {
        return rentalRepository.findByUserId(userId);
    }

    public Rental save(Rental rental) {
        return rentalRepository.save(rental);
    }

    public void updateStatus(Long rentalId, String status) {
        Rental rental = rentalRepository.findById(rentalId).orElseThrow();
        rental.setStatus(status);
        rentalRepository.save(rental);
    }
}
