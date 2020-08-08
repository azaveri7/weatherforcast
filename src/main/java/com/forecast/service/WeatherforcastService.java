package com.forecast.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

import com.forecast.entity.WeatherDetails;
import com.forecast.entity.WeatherResponse;
import com.forecast.entity.WeatherResponses;
import com.forecast.repository.WeatherforcastRepository;

@Service
public class WeatherforcastService {
	
	@Autowired
	private WeatherforcastRepository weatherforcastRepository;
	
	public WeatherResponses getWeatherForCity(String city){
		WeatherResponses response = weatherforcastRepository.getWeatherForCity(city);
		List<WeatherDetails> forecasts = response.getList();
		forecasts.stream()
		.filter(Objects::nonNull).collect(Collectors.toList());
		Collections.sort(forecasts, Collections.reverseOrder());
		List<WeatherDetails> weatherDetails = forecasts.stream()
				.limit(3)
				.map(weather -> {
					if(weather.getWeatherResponse().getTemp_max()>40) {
					weather.getWeatherResponse().setComment("carry umbrella");
					}
					return weather;
				}).collect(Collectors.toList());
			
		response.setList(weatherDetails);
		return response;
	} 
}
