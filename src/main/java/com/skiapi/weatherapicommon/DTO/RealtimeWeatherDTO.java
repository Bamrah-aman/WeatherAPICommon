package com.skiapi.weatherapicommon.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RealtimeWeatherDTO {

    private String locations;

    private int temperature;

    private  int humidity;

    private int precipitation;

    @JsonProperty("wind_speed")
    private int windSpeed;

    private String status;

    @JsonProperty("last_updated")
    private LocalDateTime lastUpdated;



}
