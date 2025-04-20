package com.WeatherObserver.weather.observer;

public class NewsChannel implements Observer {
    @Override
    public void update(float temperature, float humidity) {
        System.out.println("[NewsChannel] Broadcasting updated weather: " + temperature + "°C and " + humidity + "%");
    }
}