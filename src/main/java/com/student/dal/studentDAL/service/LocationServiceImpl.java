package com.student.dal.studentDAL.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dal.studentDAL.entities.Location;
import com.student.dal.studentDAL.repositories.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {
	
	@Autowired
	private LocationRepository locationRepos;

	@Override
	public Location saveLocation(Location location) {
		return locationRepos.save(location);
	}

	@Override
	public Location updateLocation(Location location) {
		 locationRepos.save(location);
		 return null;
	}

	@Override
	public void deleteLocation(Location location) {
		locationRepos.delete(location);
	}

	@Override
	public Location getLocationById(int id) {
		return locationRepos.findById(id).get();
	}

	@Override
	public List<Location> getAllLocation() {
		return locationRepos.findAll();
	}

	public LocationRepository getLocationRepos() {
		return locationRepos;
	}

	public void setLocationRepos(LocationRepository locationRepos) {
		this.locationRepos = locationRepos;
	}

}
