package com.riri.takehome.controller;



import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.riri.takehome.entity.Property;

@RestController
@RequestMapping(PropertyController.BASE_URI)
public class PropertyController {
	

	public static final String BASE_URI = "http://webservice-takehome-1.spookle.xyz/property?property_id=home_154";
	private static final String NOT_FOUND = "Property not found";
	
	/**
	 * @author 
	 * @param property_id
	 * @return
	 */
	
	@GetMapping("/")
	//public String getPropery(@RequestParam("ids") List<String> propertyIds) {
	public @ResponseBody String getPropery() {

		RestTemplate restTemplate = new RestTemplate();
		
		Property property =  restTemplate.getForObject("http://webservice-takehome-1.spookle.xyz/property?property_id=home_154", Property.class);
		
		return property.getOwner();
	
	}

}
