package com.WeatherObserver.weather.observer;

public class MobileAlertSystem implements Observer {
    @Override
    public void update(float temperature, float humidity) {
        System.out.println("[MobileAlert] ⚠️ Weather Changed! Temp: " + temperature + ", Humidity: " + humidity);
    }
}