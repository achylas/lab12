package com.WeatherObserver.weather;

import com.WeatherObserver.weather.observer.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(WeatherApplication.class, args);
	}
    @Override
    public void run(String... args) {
        WeatherStation station = new WeatherStation();

        Observer display = new DigitalDisplay();
        Observer stats = new StatisticsBoard();
        Observer mobile = new MobileAlertSystem();

        station.registerObserver(display);
        station.registerObserver(stats);
        station.registerObserver(mobile);

        System.out.println("=== Initial Weather Update ===");
        station.setWeather(30.5f, 65.0f);

        Observer news = new NewsChannel();
        station.registerObserver(news);

        System.out.println("\n=== Weather Update with NewsChannel Subscribed ===");
        station.setWeather(28.0f, 70.0f);
    }
}
