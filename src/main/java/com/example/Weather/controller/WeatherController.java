package com.example.Weather.controller;

import com.example.Weather.dto.RestApiObject;
import com.example.Weather.dto.WeatherResponse;
import com.example.Weather.entity.WeatherEntity;
import com.example.Weather.service.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/all")
    public List<WeatherResponse> getAllWeather() {
        return weatherService.getAllWeatherData().stream()
                .map(e -> new WeatherResponse(
                        e.getCity(),
                        e.getDescription(),
                        e.getTemperature()))
                .toList();
    }

    @GetMapping("/save")
    public ResponseEntity<String> saveWeatherForCity(@RequestParam String city) {
        weatherService.fetchAndSaveWeather(city);
        return ResponseEntity.ok("Погода для " + city + " успешно сохранена.");
    }

    @GetMapping("/weather/last")
    public RestApiObject<WeatherResponse> getLastWeather() {
        WeatherEntity entity = weatherService.getLast();
        WeatherResponse dto = new WeatherResponse(
                entity.getCity(),
                entity.getDescription(),
                entity.getTemperature()
        );

        return new RestApiObject<>(200, "Последняя погода", dto);
    }


}
