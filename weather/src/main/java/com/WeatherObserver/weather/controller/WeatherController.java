package com.WeatherObserver.weather.controller;

// controller/WeatherController.java
import com.WeatherObserver.weather.observer.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherStation station = new WeatherStation();

    public WeatherController() {
        station.registerObserver(new DigitalDisplay());
        station.registerObserver(new StatisticsBoard());
        station.registerObserver(new MobileAlertSystem());
    }

    @PostMapping("/update")
    public String updateWeather(@RequestParam float temp, @RequestParam float humidity) {
        station.setWeather(temp, humidity);
        return "Weather updated!";
    }

    @PostMapping("/add-news-channel")
    public String addNewsChannel() {
        station.registerObserver(new NewsChannel());
        return "NewsChannel observer added.";
    }
}

