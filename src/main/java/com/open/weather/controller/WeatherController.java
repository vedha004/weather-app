package com.open.weather.controller;


import com.open.weather.dto.WeatherRequestDto;
import com.open.weather.service.WeatherSerives;
import com.open.weather.utils.ResponseBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherSerives weatherSerives;


    @PostMapping("/weather")
    public ResponseEntity<Object> getWeather(@RequestBody WeatherRequestDto weatherRequestDto) {


        Map<String, Object> responseMap = weatherSerives.getWeather(weatherRequestDto.cityName);

        return ResponseBuilder
                .buildResponse(responseMap.get("message").toString(),
                        HttpStatus.OK,responseMap.get("resposeObj"));
    }


}
