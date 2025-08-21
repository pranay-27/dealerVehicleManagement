package com.taskApi.demo.controller;

import com.taskApi.demo.entity.Vehicle;
import com.taskApi.demo.entity.Dealer;
import com.taskApi.demo.service.VehicleService;
import com.taskApi.demo.service.DealerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;
    private final DealerService dealerService;

    @PostMapping
    public Vehicle createVehicle(@RequestParam Long dealerId, @RequestBody Vehicle vehicle) {
        return vehicleService.saveVehicle(dealerId, vehicle);
    }

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
        return vehicleService.getVehicleById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
    }

    @GetMapping("/premium")
    public List<Vehicle> getVehiclesOfPremiumDealers() {
        List<Dealer> premiumDealers = dealerService.getPremiumDealers();
        List<Vehicle> premiumVehicles = new ArrayList<>();

        for (Dealer dealer : premiumDealers) {
            premiumVehicles.addAll(vehicleService.getVehiclesByDealerId(dealer.getId()));
        }

        return premiumVehicles;
    }
}
