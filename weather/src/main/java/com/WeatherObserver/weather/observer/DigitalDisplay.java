package com.WeatherObserver.weather.observer;

public class DigitalDisplay implements Observer {
    @Override
    public void update(float temperature, float humidity) {
        System.out.println("[DigitalDisplay] Temp: " + temperature + "°C, Humidity: " + humidity + "%");
    }
}