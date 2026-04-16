package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entiry.Vehicle;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.VehicleService;

@RestController
@RequestMapping("vehicles")
public class VehicleController {

    @Autowired
    private VehicleService service;

    
    @PostMapping("/add")
    public ApiResponse addVehicle(@RequestBody Vehicle vehicle) {
        return service.addVehicle(vehicle);
    }

    
    @GetMapping("/all")
    public List<Vehicle> getAllVehicles() {
        return service.getAllVehicles();
    }

  
    @GetMapping("/available")
    public List<Vehicle> getAvailableVehicles() {
        return service.getAvailableVehicles();
    }

  
    @GetMapping("/{vehicleNumber}")
    public List<Vehicle> getByVehicleNumber(@PathVariable String vehicleNumber) {
        return service.getByVehicleNumber(vehicleNumber);
    }
}