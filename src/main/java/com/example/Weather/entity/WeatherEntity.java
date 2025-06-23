package com.example.Weather.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;



import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class WeatherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;
    private String description;
    private double temperature;
    private LocalDateTime timestamp;


    public Long getId() {
        return id;
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

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}

