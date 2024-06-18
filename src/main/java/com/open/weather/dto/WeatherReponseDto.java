package com.open.weather.dto;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherReponseDto {

    private double longitude;
    private double latitude;
    private String weatherDescription;
    private double temperature;
    private double feelsLike;
    private double minimumTemperature;
    private double maximumTemperature;

}
