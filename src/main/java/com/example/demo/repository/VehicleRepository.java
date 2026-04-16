package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entiry.Vehicle;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
	
	
	public Optional<Vehicle> findByVehicleNumber(String vehicleNumber); 
	
	


}
