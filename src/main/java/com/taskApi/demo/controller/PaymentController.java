package com.taskApi.demo.controller;

import com.taskApi.demo.entity.Payment;
import com.taskApi.demo.enums.PaymentStatus;
import com.taskApi.demo.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    @PostMapping("/initiate")
    public Payment initiatePayment(@RequestParam Long dealerId, @RequestBody Payment payment) {
        Payment savedPayment = paymentService.initiatePayment(dealerId, payment);

        scheduler.schedule(() -> {
            paymentService.updatePaymentStatus(savedPayment.getId(), PaymentStatus.SUCCESS);
        }, 5, TimeUnit.SECONDS);

        return savedPayment;
    }
    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable Long id) {
        return paymentService.getPaymentById(id);
    }
}
