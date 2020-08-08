package com.forecast.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse implements Comparable<WeatherResponse> {

	
	private Double temp_max;
	private Double temp_min;
	private String comment;
	
	public Double getTemp_max() {
		return temp_max - 273.15;
	}
	public void setTemp_max(Double temp_max) {
		this.temp_max = temp_max;
	}
	public Double getTemp_min() {
		return temp_min - 273.15;
	}
	public void setTemp_min(Double temp_min) {
		this.temp_min = temp_min;
	}
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
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
