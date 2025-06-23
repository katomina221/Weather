package com.example.Weather.dto;


public class WeatherResponse {
    private String city;
    private String description;
    private double temperature;

    public WeatherResponse(String city, String description, double temperature) {
        this.city = city;
        this.description = description;
        this.temperature = temperature;
    }


    public String getCity() {
        return city;
    }

    public String getDescription() {
        return description;
    }

    public double getTemperature() {
        return temperature;
    }
}
