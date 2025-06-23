package com.example.Weather.dto;



import java.util.List;

public class OpenWeatherMapResponse {

    private Main main;
    private List<Weather> weather;
    private String name;

    public Main getMain() {
        return main;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public String getName() {
        return name;
    }

    public static class Main {
        private double temp;

        public double getTemp() {
            return temp;
        }
    }

    public static class Weather {
        private String description;

        public String getDescription() {
            return description;
        }
    }
}
