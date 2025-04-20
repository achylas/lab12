package com.WeatherObserver.weather.observer;
public class StatisticsBoard implements Observer {
    @Override
    public void update(float temperature, float humidity) {
        System.out.println("[StatisticsBoard] Stats updated - Temp: " + temperature + ", Humidity: " + humidity);
    }
}