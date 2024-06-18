package com.open.weather.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseBuilder {

    public static ResponseEntity<Object> buildResponse(String message, HttpStatus httpStatus, Object responsObject) {

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("message", message);
        responseMap.put("status", httpStatus);
        responseMap.put("data", responsObject);

        return new ResponseEntity<>(responseMap, httpStatus);
    }

}
