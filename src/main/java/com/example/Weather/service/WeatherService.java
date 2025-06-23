package com.example.Weather.service;

import com.example.Weather.dto.OpenWeatherMapResponse;
import com.example.Weather.entity.WeatherEntity;
import com.example.Weather.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    @Value("${weather.api.url}")
    private String apiUrl;

    private final RestTemplate restTemplate;
    private final WeatherRepository weatherRepository;

    public WeatherService(RestTemplate restTemplate, WeatherRepository weatherRepository) {
        this.restTemplate = restTemplate;
        this.weatherRepository = weatherRepository;
    }

    public void fetchAndSaveWeather(String city) {
        try {
            String url = apiUrl + "?q=" + city + "&appid=" + apiKey + "&units=metric";
            OpenWeatherMapResponse response = restTemplate.getForObject(url, OpenWeatherMapResponse.class);

            WeatherEntity entity = new WeatherEntity();
            entity.setCity(response.getName());
            entity.setDescription(response.getWeather().get(0).getDescription());
            entity.setTemperature(response.getMain().getTemp());
            entity.setTimestamp(LocalDateTime.now());


            weatherRepository.save(entity);


        } catch (Exception e) {
            System.out.println("Ошибка при получении погоды: " + e.getMessage());
        }
    }


    public List<WeatherEntity> getAllWeatherData() {
        return weatherRepository.findAll();
    }
    public WeatherEntity getLast() {
        return weatherRepository.findTopByOrderByTimestampDesc();
    }



}
