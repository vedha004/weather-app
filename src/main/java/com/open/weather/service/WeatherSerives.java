package com.open.weather.service;

import java.util.Map;

public interface WeatherSerives {

    Map<String,Object> getWeather(String cityName);

}
