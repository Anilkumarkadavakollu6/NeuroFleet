package com.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portal.model.Vehicle;

public interface VehicleRepository
        extends JpaRepository<Vehicle, Long> {
}
