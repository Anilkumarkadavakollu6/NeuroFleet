package com.portal.service;

import com.portal.model.Vehicle;
import com.portal.repository.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    private final VehicleRepository repo;

    public VehicleService(VehicleRepository repo) {
        this.repo = repo;
    }

    public List<Vehicle> getAllVehicles() {
        return repo.findAll();
    }

    public Vehicle saveVehicle(Vehicle v) {
        return repo.save(v);
    }

    public void deleteVehicle(Long id) {
        repo.deleteById(id);
    }
}
