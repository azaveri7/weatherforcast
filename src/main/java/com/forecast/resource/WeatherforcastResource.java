package com.forecast.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import java.util.*;

import com.forecast.entity.WeatherForcast;
import com.forecast.entity.WeatherResponses;
import com.forecast.service.WeatherforcastService;

@RestController
public class WeatherforcastResource {
	
	@Autowired
	private WeatherforcastService weatherforcastService;
	
	@GetMapping(value = "/getWeather/{city}", produces = MediaType.APPLICATION_JSON_VALUE)
	public WeatherResponses hello(@PathVariable String city) {
		return weatherforcastService.getWeatherForCity(city);
	}

}
