package com.student.dal.studentDAL.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.dal.studentDAL.entities.Location;
import com.student.dal.studentDAL.repositories.LocationRepository;

@RestController
@RequestMapping("/locations")
public class LocationRestController {
	
	@Autowired
	LocationRepository locationRepo;
	
	@GetMapping("/")
	public List<Location> findLocations(){
		List<Location> locations = locationRepo.findAll();
		return locations;
	}
	@GetMapping("{id}")
	public Location getLocation(@PathVariable int id) {
		Location location = locationRepo.findById(id).get();
		 return location;
		
	}
	
	@PostMapping
	public Location saveLocation( @RequestBody Location location) {
//		Location savedLocation = new Location(12 , "text" , "hussam" , "Ahmed");
		Location savedLocation = locationRepo.save(location);
		return savedLocation;
	}
	@PutMapping
	public Location updateLocation(@RequestBody Location location) {
		Location savedlocation = locationRepo.save(location);
		return savedlocation;
	}
	@DeleteMapping("/{id}")
	public void deleteLocation(@PathVariable("id") int id) {
//		locationRepo.delete(location);
		locationRepo.deleteById(id);
	}
}
