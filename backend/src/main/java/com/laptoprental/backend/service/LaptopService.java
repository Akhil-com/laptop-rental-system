package com.laptoprental.backend.service;

import com.laptoprental.backend.entity.Laptop;
import com.laptoprental.backend.repositories.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {
    @Autowired
    private LaptopRepository laptopRepository;

    public List<Laptop> findAll() {
        return laptopRepository.findAll();
    }

    public Laptop save(Laptop laptop) {
        return laptopRepository.save(laptop);
    }

    public void delete(Long id) {
        laptopRepository.deleteById(id);
    }
}
