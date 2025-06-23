package com.example.Weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Weather.entity.WeatherEntity;

public interface WeatherRepository extends JpaRepository<WeatherEntity, Long> {
    WeatherEntity findTopByOrderByTimestampDesc();
}



