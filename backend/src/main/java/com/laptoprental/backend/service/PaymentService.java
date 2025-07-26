package com.laptoprental.backend.service;

import com.laptoprental.backend.entity.Payment;
import com.laptoprental.backend.repositories.PaymentRepository;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private RazorpayClient razorpayClient;

    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    public List<Payment> getByUserId(Long userId) {
        return paymentRepository.findByUserId(userId);
    }

    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    // ✅ FIXED: Now this is outside the save() method
    public String createOrder(Double amount) throws RazorpayException {
        JSONObject orderRequest = new JSONObject();
        orderRequest.put("amount", (int)(amount * 100)); // in paise
        orderRequest.put("currency", "INR");
        orderRequest.put("receipt", UUID.randomUUID().toString());
        orderRequest.put("payment_capture", 1);

        Order order = razorpayClient.orders.create(orderRequest);
        return order.toString();
    }
}
