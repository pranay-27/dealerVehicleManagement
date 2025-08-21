package com.taskApi.demo.service;

import com.taskApi.demo.entity.Dealer;
import com.taskApi.demo.enums.SubscriptionType;
import com.taskApi.demo.repository.DealerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DealerService {

    private final DealerRepository dealerRepository;

    public Dealer saveDealer(Dealer dealer) {
        return dealerRepository.save(dealer);
    }

    public List<Dealer> getAllDealers() {
        return dealerRepository.findAll();
    }

    public Optional<Dealer> getDealerById(Long id) {
        return dealerRepository.findById(id);
    }

    public void deleteDealer(Long id) {
        dealerRepository.deleteById(id);
    }

    public List<Dealer> getPremiumDealers() {
        return dealerRepository.findBySubscriptionType(SubscriptionType.PREMIUM);
    }
}
