package ru.kpfu.itis.bagautdinov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.itis.bagautdinov.model.User;
import ru.kpfu.itis.bagautdinov.model.Weather;
import ru.kpfu.itis.bagautdinov.repository.UserRepository;
import ru.kpfu.itis.bagautdinov.repository.WeatherRepository;
import ru.kpfu.itis.bagautdinov.service.WeatherService;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class WeatherController {
    private final WeatherService weatherService = new WeatherService();
    private final WeatherRepository weatherRepository;
    private final UserRepository userRepository;
    @Autowired
    public WeatherController(WeatherRepository weatherRepository, UserRepository userRepository) {
        this.weatherRepository = weatherRepository;
        this.userRepository = userRepository;
    }


    @GetMapping("/weather")
    public Weather addWeather(@Valid @RequestParam Optional<String> city) throws IOException {
        Map<String, String> result = weatherService.get(city.orElse("Kazan"));
        return weatherRepository.save(new Weather(result.get("name"), result.get("temp"), result.get("feels_like"), result.get("wind_speed"), new Date().getTime()));
    }

    @GetMapping("/getWeather")
    public String getWeather(@RequestParam String email) {
        List<User> users = userRepository.findAll();
        List<Weather> weatherList = weatherRepository.findAll();
        String result = "";
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                for (Weather weather : weatherList) {
                    result += weather.toString() + "\n";
                }
            }
        }
        return result;
    }

    @GetMapping("/getAll")
    public String getAll(){
        List<User> users = userRepository.findAll();
        List<Weather> weatherList = weatherRepository.findAll();
        String result = "";
        for (User user : users) {
            result += user.toString() + "\n";
        }
        for (Weather weather : weatherList) {
            result += weather.toString()+"\n";
        }
        return result;
    }
}
