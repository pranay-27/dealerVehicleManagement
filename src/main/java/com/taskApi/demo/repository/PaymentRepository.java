package com.taskApi.demo.repository;

import com.taskApi.demo.entity.Payment;
import com.taskApi.demo.enums.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,Long> {

    List<Payment> findByStatus(PaymentStatus status);
}
