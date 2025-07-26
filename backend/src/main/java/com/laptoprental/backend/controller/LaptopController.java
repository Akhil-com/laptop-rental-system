package com.laptoprental.backend.controller;

import com.laptoprental.backend.entity.Laptop;
import com.laptoprental.backend.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/laptops")
public class LaptopController {
    @Autowired
    private LaptopService laptopService;

    @GetMapping
    public List<Laptop> getAll() {
        return laptopService.findAll();
    }

    @PostMapping
    public Laptop create(@RequestBody Laptop laptop) {
        return laptopService.save(laptop);
    }
}