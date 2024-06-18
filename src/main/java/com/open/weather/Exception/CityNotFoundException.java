package com.open.weather.Exception;

public class CityNotFoundException extends RuntimeException{

    public CityNotFoundException(String message){
        super(message);
    }

    public CityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
