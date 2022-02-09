package ru.kpfu.itis.bagautdinov.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.itis.bagautdinov.service.WeatherService;

import java.io.IOException;
import java.util.Optional;

@RestController
public class WeatherController {
    private final WeatherService weatherService = new WeatherService();

    @GetMapping("/weather")
    public String getWeather(@RequestParam Optional<String> city) throws IOException {
        return weatherService.get(city.orElse("Kazan"));
    }
}
