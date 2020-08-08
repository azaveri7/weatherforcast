package com.forecast.entity;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponses {

	private String cod;
	private int cnt;
	private List<WeatherDetails> list;
	
	public String getCod() {
		return cod;
	}
	public void setCod(String cod) {
		this.cod = cod;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public List<WeatherDetails> getList() {
		return list;
	}
	public void setList(List<WeatherDetails> list) {
		this.list = list;
	}
	
	
	
	
}
