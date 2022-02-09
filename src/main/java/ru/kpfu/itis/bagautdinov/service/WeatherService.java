package ru.kpfu.itis.bagautdinov.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class WeatherService {
    public String get(String city) throws IOException {
        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=" + city
                + "&appid=" + "4b2439828bcaaafe86e1381e2a3c5c51");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        StringBuilder result = new StringBuilder();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(1000);
        connection.setReadTimeout(1000);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String input;
            while ((input = reader.readLine()) != null) {
                result.append(input);
            }
        }
        connection.disconnect();

        return result.toString();
    }
}
