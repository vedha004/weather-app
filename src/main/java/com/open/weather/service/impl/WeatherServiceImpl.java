package com.open.weather.service.impl;

import com.open.weather.Exception.CityNotFoundException;
import com.open.weather.dto.WeatherReponseDto;
import com.open.weather.service.WeatherSerives;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@Slf4j
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherSerives {

    @Value("${openweather.api.url}")
    private String OPENWEATHER_API_URL;

    @Value("${openweather.api.key}")
    private String OPENWEATHER_API_KEY;

    private final RestTemplate restTemplate;

    @Override
    public Map<String, Object> getWeather(String cityName) {

        String urlString = OPENWEATHER_API_URL + "?q=" + cityName + "&appid=" + OPENWEATHER_API_KEY;

        //{coord={lon=77.6033, lat=12.9762},
        // weather=[{id=802, main=Clouds, description=scattered clouds, icon=03d}],
        // base=stations, main={temp=302.95, feels_like=304.54, temp_min=301.05,
        // temp_max=303.99, pressure=1010, humidity=54},
        // visibility=8000, wind={speed=6.17, deg=250},
        // clouds={all=40}, dt=1718710159,
        // sys={type=2, id=2017753, country=IN, sunrise=1718670247, sunset=1718716644},
        // timezone=19800, id=1277333, name=Bengaluru, cod=200}
        Map weatherMap = null;
        try {
            weatherMap = restTemplate.getForObject(urlString, Map.class);
        }
        catch (Exception e){
            log.error(e.getMessage());
            throw new CityNotFoundException("City with name '" + cityName + "' not found.");
        }
        Map<String, Double> coord = (Map<String, Double>) weatherMap.get("coord");
        double longitude = coord.get("lon");
        double latitude = coord.get("lat");

        Map<String, Object> weather = ((List<Map<String, Object>>) weatherMap.get("weather")).get(0);
        String weatherDescription = (String) weather.get("description");

        Map<String, Double> main = (Map<String, Double>) weatherMap.get("main");
        double temperature = main.get("temp");
        double feelsLike = main.get("feels_like");
        double minimumTemperature = main.get("temp_min");
        double maximumTemperature = main.get("temp_max");

        WeatherReponseDto weatherReponseDto = WeatherReponseDto.builder()
                .longitude(longitude)
                .latitude(latitude)
                .weatherDescription(weatherDescription)
                .temperature(temperature)
                .feelsLike(feelsLike)
                .minimumTemperature(minimumTemperature)
                .maximumTemperature(maximumTemperature)
                .build();
//        WeatherReponseDto.builder().latitude(respose.get("coord").)

        Map<String, Object> responseMap = new HashMap<String, Object>();
        responseMap.put("message","Weather information retrieved successfully.");
        responseMap.put("resposeObj", weatherReponseDto);
        return responseMap;
    }
}
