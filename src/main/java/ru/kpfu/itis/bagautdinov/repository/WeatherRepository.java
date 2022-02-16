package ru.kpfu.itis.bagautdinov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kpfu.itis.bagautdinov.model.Weather;

public interface WeatherRepository extends JpaRepository<Weather, Integer> {
}
