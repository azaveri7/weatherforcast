package com.forecast.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDetails implements Comparable<WeatherDetails>{
	private String dt;
	@JsonProperty(value = "main")
	private WeatherResponse weatherResponse;
	public String getDt() {
		return dt;
	}
	public void setDt(String dt) {
		this.dt = dt;
	}
	public WeatherResponse getWeatherResponse() {
		return weatherResponse;
	}
	public void setWeatherResponse(WeatherResponse weatherResponse) {
		this.weatherResponse = weatherResponse;
	}
	@Override
	public int compareTo(WeatherDetails o) {
		return o.getWeatherResponse().compareTo(this.weatherResponse);
	}
	
	
	
	
}
