package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.domain.*;
import com.example.service.CityService;

@RestController
public class CityRestController {
	
	@Autowired
	private CityService cityService;
	
	@GetMapping("/api/cities/{city}")
	public CityInfo getWeather(@PathVariable("city") String cityName) {
		CityInfo cityInfo = cityService.getCityInfo(cityName);
		if (cityInfo == null) {
			return null;
			//return new ResponseEntity<CityInfo>( HttpStatus.NOT_FOUND);
		}		
		return cityInfo;		
	}
	
}
