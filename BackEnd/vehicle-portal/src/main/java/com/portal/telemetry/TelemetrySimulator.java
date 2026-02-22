package com.portal.telemetry;

import com.portal.model.Vehicle;
import com.portal.repository.VehicleRepository;
import org.springframework.scheduling.annotation.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Random;

@Component
public class TelemetrySimulator {

    private final VehicleRepository repo;
    Random random = new Random();

    public TelemetrySimulator(VehicleRepository repo) {
        this.repo = repo;
    }

    @Scheduled(fixedRate = 5000)
    public void simulate() {

        List<Vehicle> vehicles = repo.findAll();

        for(Vehicle v : vehicles){

            v.setSpeed(random.nextInt(100));
            v.setBattery(Math.max(0, v.getBattery()-1));
            v.setFuel(Math.max(0, v.getFuel()-1));

            v.setLatitude(v.getLatitude()+0.0001);
            v.setLongitude(v.getLongitude()+0.0001);

            repo.save(v);
        }
    }
}