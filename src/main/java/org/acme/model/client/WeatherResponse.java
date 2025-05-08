package org.acme.model.client;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class WeatherResponse {
    @Id
    @SequenceGenerator(name = "weather_response_seq", sequenceName = "weather_response_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "weather_response_seq")
    private Long id;

    private String temperature;
    private String wind;
    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<WeatherResponse> forecast;

    public WeatherResponse() {
    }

    public WeatherResponse(String temperature, String wind, String description) {
        this.temperature = temperature;
        this.wind = wind;
        this.description = description;
    }

    public Long getId() {
        return id;
    }


    public String getTemperature() {
        return temperature;
    }

    public String getWind() {
        return wind;
    }

    public String getDescription() {
        return description;
    }

    public List<WeatherResponse> getForecast() {
        return forecast;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setForecast(List<WeatherResponse> forecast) {
        this.forecast = forecast;
    }
}
