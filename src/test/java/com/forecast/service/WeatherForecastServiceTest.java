package com.forecast.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.forecast.entity.WeatherDetails;
import com.forecast.entity.WeatherResponse;
import com.forecast.entity.WeatherResponses;
import com.forecast.repository.WeatherforcastRepository;

@RunWith(MockitoJUnitRunner.class)
public class WeatherForecastServiceTest {
@Mock
private WeatherforcastRepository repository;

@InjectMocks
private WeatherforcastService service;

@Before
public void setup() {
	MockitoAnnotations.initMocks(this);
}

@Test
public void shouldReturnHighest3Temp() {
	WeatherResponses response = new WeatherResponses();
	WeatherDetails weatherDetail = new WeatherDetails();
	WeatherResponse weatherResponse = new WeatherResponse();
	weatherResponse.setTemp_max(100.0);
	weatherResponse.setTemp_min(10.0);
	weatherDetail.setWeatherResponse(weatherResponse);
	
	WeatherDetails weatherDetails1 = new WeatherDetails();
	WeatherResponse weatherResponse1 = new WeatherResponse();
	weatherResponse1.setTemp_max(900.0);
	weatherResponse1.setTemp_min(10.0);
	weatherDetails1.setWeatherResponse(weatherResponse1);
	
	WeatherDetails weatherDetails2 = new WeatherDetails();
	WeatherResponse weatherResponse2 = new WeatherResponse();
	weatherResponse2.setTemp_max(1000.0);
	weatherResponse2.setTemp_min(10.0);
	weatherDetails2.setWeatherResponse(weatherResponse2);
	
	WeatherDetails weatherDetails3 = new WeatherDetails();
	WeatherResponse weatherResponse3 = new WeatherResponse();
	weatherResponse3.setTemp_max(130.0);
	weatherResponse3.setTemp_min(10.0);
	weatherDetails3.setWeatherResponse(weatherResponse3);
	
	List<WeatherDetails> weatherDetails = new ArrayList();
	weatherDetails.add(weatherDetails2);
	weatherDetails.add(weatherDetails1);
	weatherDetails.add(weatherDetail);
	weatherDetails.add(weatherDetails3);
	
	response.setList(weatherDetails);
	
	when(repository.getWeatherForCity("london")).thenReturn(response);
	WeatherResponses details = service.getWeatherForCity("london");
	
	assertEquals(3,details.getList().size());
}


}
