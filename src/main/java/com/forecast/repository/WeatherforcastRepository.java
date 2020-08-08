package com.forecast.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.forecast.entity.WeatherResponses;

@Repository
public class WeatherforcastRepository {
	
private RestTemplate restTemplate;
	
	@PostConstruct
	public void init() {
		restTemplate = new RestTemplate();
	}
	
public WeatherResponses getWeatherForCity(String city){
		
		HttpEntity<WeatherResponses> entity = new HttpEntity<>(getHttpHeaders());
		return restTemplate.exchange("https://samples.openweathermap.org/data/2.5/forecast?q="+city+",us&appid=d2929e9483efc82c82c32ee7%20e02d563e", 
				HttpMethod.GET, entity, WeatherResponses.class).getBody();
	}
	
	private HttpHeaders getHttpHeaders() {
		HttpHeaders headers = new HttpHeaders();
		List<MediaType> acceptableMediaTypes = new ArrayList<>();
		acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
		headers.setAccept(acceptableMediaTypes);
		return headers;
	}

}
