package com.portal.controller;

import com.portal.model.Vehicle;
import com.portal.service.VehicleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicles")	
@CrossOrigin(origins = "http://localhost:3000")
public class VehicleController {

    private final VehicleService service;

    public VehicleController(VehicleService service) {
        this.service = service;
    }

    @GetMapping
    public List<Vehicle> getAll() {
        return service.getAllVehicles();
    }

    @PostMapping
    public Vehicle add(@RequestBody Vehicle v) {
        return service.saveVehicle(v);
    }

    @PutMapping("/{id}")
    public Vehicle update(@PathVariable Long id,
                          @RequestBody Vehicle v) {
        v.setId(id);
        return service.saveVehicle(v);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteVehicle(id);
    }
}
