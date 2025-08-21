package com.taskApi.demo.service;

import com.taskApi.demo.entity.Dealer;
import com.taskApi.demo.entity.Vehicle;
import com.taskApi.demo.repository.DealerRepository;
import com.taskApi.demo.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final DealerRepository dealerRepository;

    public Vehicle saveVehicle(Long dealerId, Vehicle vehicle) {
        Dealer dealer = dealerRepository.findById(dealerId)
                .orElseThrow(() -> new RuntimeException("Dealer not found with id: " + dealerId));
        vehicle.setDealer(dealer);
        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Optional<Vehicle> getVehicleById(Long id) {
        return vehicleRepository.findById(id);
    }

    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }

    public List<Vehicle> getVehiclesByDealerId(Long dealerId) {
        return vehicleRepository.findByDealerId(dealerId);
    }
}
