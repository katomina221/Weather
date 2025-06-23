package com.example.Weather.scheduler;

import com.example.Weather.service.WeatherService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WeatherScheduler {

    private final WeatherService weatherService;

    public WeatherScheduler(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @Scheduled(fixedRate = 3600000)
    public void scheduleWeatherUpdate() {
        weatherService.fetchAndSaveWeather("Tashkent");
    }
}
