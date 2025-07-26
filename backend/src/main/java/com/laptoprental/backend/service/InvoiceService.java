package com.laptoprental.backend.service;

import com.laptoprental.backend.entity.Invoice;
import com.laptoprental.backend.entity.Rental;
import com.laptoprental.backend.repositories.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    public List<Invoice> getAll() {
        return invoiceRepository.findAll();
    }

    public List<Invoice> getByUserId(Long userId) {
        return invoiceRepository.findByRental_UserId(userId);
    }

    public Invoice generateInvoiceForRental(Rental rental) {
        Invoice invoice = new Invoice();
        invoice.setRental(rental);
        invoice.setId(rental.getId());
        invoice.setGeneratedDate((LocalDate.now()));
        invoice.setAmount(rental.getAmount());

        return invoiceRepository.save(invoice);
    }
}
