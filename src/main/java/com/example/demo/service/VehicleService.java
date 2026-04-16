package com.example.demo.service;

import java.util.List;

import com.example.demo.entiry.Vehicle;
import com.example.demo.response.ApiResponse;

public interface VehicleService {
	
	public ApiResponse addVehicle(Vehicle vehicle);
	
	public List<Vehicle> getAllVehicles();
	
	
	 public List<Vehicle> getAvailableVehicles();
	 
	 public List<Vehicle> getByVehicleNumber(String vechicleNumber);
	 
	 
	 
	 
	

}
