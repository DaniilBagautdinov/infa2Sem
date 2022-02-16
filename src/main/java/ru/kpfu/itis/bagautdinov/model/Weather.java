package ru.kpfu.itis.bagautdinov.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "weather")

public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String temp;

    private String feelsLike;

    private String windSpeed;

    private long time;

    public Weather(String name, String temp, String feelsLike, String windSpeed, long time) {
        this.name = name;
        this.temp = temp;
        this.feelsLike = feelsLike;
        this.windSpeed = windSpeed;
        this.time = time;
    }

    public Weather() {

    }

    @Override
    public String toString() {
        return "Weather{" +
                "name='" + name + '\'' +
                ", temp='" + temp + '\'' +
                ", feelsLike='" + feelsLike + '\'' +
                ", windSpeed='" + windSpeed + '\'' +
                ", time=" + time +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(String feelsLike) {
        this.feelsLike = feelsLike;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }
}
