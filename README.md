# Getting Started

# Spring Boot Application Setup and Run Guide

This guide provides instructions on setting up and running the Spring Boot application.

## Prerequisites

Before you begin, ensure you have the following installed on your machine:

- Java Development Kit (JDK) version 8 or higher
- Maven build tool
- Your preferred IDE (IntelliJ IDEA, Eclipse, etc.) [Optional]

## Setup Instructions

1. **Clone**
2. **If you are using command-line interface:**
   mvn spring-boot:run
3.**If using ide import the project and run WeatherInformationApplication**
4. **Open your Postman or any other API platform tool**

# Weather Service API

## Description

This API provides weather information based on city names.

## Endpoint


## Request Body

- **Content-Type:** application/json

```json
{
    "cityName": "Bangalore"
}
```

## Response Body

- **Content-Type:** application/json

```json
{
  "data": {
    "longitude": 77.6033,
    "latitude": 12.9762,
    "weatherDescription": "scattered clouds",
    "temperature": 301.94,
    "feelsLike": 303.55,
    "minimumTemperature": 298.05,
    "maximumTemperature": 303.91
  },
  "message": "Weather information retrieved successfully.",
  "status": "OK"
}
```


