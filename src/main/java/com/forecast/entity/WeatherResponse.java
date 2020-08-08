package com.forecast.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse implements Comparable<WeatherResponse> {

	
	private Double temp_max;
	private Double temp_min;
	
	public Double getTemp_max() {
		return temp_max;
	}
	public void setTemp_max(Double temp_max) {
		this.temp_max = temp_max;
	}
	public Double getTemp_min() {
		return temp_min;
	}
	public void setTemp_min(Double temp_min) {
		this.temp_min = temp_min;
	}
	
	@Override
	public String toString() {
		return this.temp_max + " " + this.temp_min;
	}
	@Override
	public int compareTo(WeatherResponse o) {
		return o.temp_max.compareTo(this.temp_max);
	}
	
}
