package com.taskApi.demo.controller;

import com.taskApi.demo.entity.Dealer;
import com.taskApi.demo.service.DealerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dealers")
@RequiredArgsConstructor
public class DealerController {

    private final DealerService dealerService;

    @PostMapping
    public Dealer createDealer(@RequestBody Dealer dealer) {
        return dealerService.saveDealer(dealer);
    }

    @GetMapping
    public List<Dealer> getAllDealers() {
        return dealerService.getAllDealers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dealer> getDealerById(@PathVariable Long id) {
        return dealerService.getDealerById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deleteDealer(@PathVariable Long id) {
        dealerService.deleteDealer(id);
    }

    @GetMapping("/premium")
    public List<Dealer> getPremiumDealers() {
        return dealerService.getPremiumDealers();
    }
}
