package com.student.dal.studentDAL.controllers;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.student.dal.studentDAL.entities.Location;
import com.student.dal.studentDAL.repositories.LocationRepository;
import com.student.dal.studentDAL.service.LocationService;
import com.student.dal.studentDAL.util.EmailUtil;
import com.student.dal.studentDAL.util.ReportUtil;

@Controller
public class LocationController {
	
	@Autowired
	private LocationService service;
	
	@Autowired
	private LocationRepository repo;
	
	@Autowired
	EmailUtil emailUtil;
	
	@Autowired
	ReportUtil reportUtil;
	
	@Autowired
	ServletContext sc;

	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createLocation";
	}
	
//	@ModelAttribute("location") the Location that comes in the request 
	@RequestMapping(value="/saveloc" )
	public String saveLocation(@ModelAttribute("location") Location location , ModelMap modelMap) {
		Location locationSaved = service.saveLocation(location);
		String msg = "Location Saved With id : " + locationSaved.getId();
		modelMap.addAttribute("msg" , msg); 
		modelMap.addAttribute("name" , location.getName()); 
		emailUtil.sendEmail("hossam10elmaghraby@gmail.com","location Saved ", "Your Location Has been Saved Now ");
		return "createLocation";
	}
	@RequestMapping("/displayLocations")
	public String dispalyLocaitons(ModelMap modelMap) {
		List<Location> locations = service.getAllLocation();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
	}
	@RequestMapping("/deleteLocations")
	// handle id which extists in the request ..
	public String deleteLocation(@RequestParam("id") int id , ModelMap modelMap) {
		Location location = new Location();
		location.setId(id);
		service.deleteLocation(location);
		List<Location> locations = service.getAllLocation();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
	}
	@RequestMapping("/showUpdate")
	public String updateLocation(@RequestParam("id") int id , ModelMap modelMap ) {
		Location location =service.getLocationById(id);
		modelMap.addAttribute("location", location);
		return "updateLocation";
	}
	@RequestMapping(value="/updateLoc" , method =RequestMethod.POST)
	public String updateLoc(@ModelAttribute("location") Location location , ModelMap modelMap) {
		service.updateLocation(location);
		List<Location> locations = service.getAllLocation();
		modelMap.addAttribute("locations", locations);
		return "displayLocations";
	}
	@RequestMapping("/generateReport")
	public String generateReport() {
		// get the dataset ..
		List<Object[]> data = repo.findTypeAndTypeCount();
		String path = sc.getRealPath("/");
		reportUtil.generatePieChart(path, data);
		return "report";
	}
}
