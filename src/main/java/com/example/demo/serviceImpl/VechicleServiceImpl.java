package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entiry.Vehicle;
import com.example.demo.repository.VehicleRepository;
import com.example.demo.response.ApiResponse;
import com.example.demo.service.VehicleService;

@Service
public class VechicleServiceImpl implements VehicleService{
	
	
	@Autowired
	private VehicleRepository repository;
	

	@Override
	public ApiResponse addVehicle(Vehicle vehicle) {
		
		Optional<Vehicle> byVehicleNumber = repository.findByVehicleNumber(vehicle.getVehicleNumber());
		
		if(byVehicleNumber.isPresent())
		{
			 return ApiResponse.builder()
		                .status(false)
		                .message("Vehicle Number Already Registered")
		                .obj(null)
		                .build();		
			}
		else 
		{
			Vehicle save = repository.save(vehicle);
		
		
			return ApiResponse.builder().status(true).message("Vechicle Added....").obj(save).build();
		}

		
	}

	@Override
	public List<Vehicle> getAllVehicles() {
		
		
		// TODO Auto-generated method stub
		List<Vehicle> all = repository.findAll();
		return all;
	}

	@Override
	public List<Vehicle> getAvailableVehicles() {
		// TODO Auto-generated method stub
		 return repository.findAll()
	                .stream()
	                .filter(Vehicle::isAvailable)
	                .toList();
	}

	@Override
	public List<Vehicle> getByVehicleNumber(String vechicleNumber) {
		
		
		Optional<Vehicle> byVehicleNumber = repository.findByVehicleNumber(vechicleNumber);
		  Vehicle vehicle = byVehicleNumber.get();
		  
		  if(byVehicleNumber.isPresent())
		  {
			  return List.of(vehicle); 
		  }
		  else
		  {
			  return null;
		  }
		  
		
		
	}

}
