package com.skiapi.weatherapicommon.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "realtime_weather")
public class RealtimeWeather {

    @Id
    @Column(name = "location_code")
    private String locationCode;

    private int temperature;

    private  int humidity;

    private int precipitation;

    @JsonProperty("wind_speed")
    private int windSpeed;

    @Column(length = 50)
    private String status;

    @JsonProperty("last_updated")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "YYYY-MM-dd'T'HH:mm:ss'Z'")
    private LocalDateTime lastUpdated;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId //We use this annotation when we do not want to declare a separate Foreign Key and want to use existing Primary Key as FK of current entity
    @JoinColumn(name = "location_code") //As primary and foreign key are same so same name used if we use different name it will create separate column
    private Locations locations;

    public void setLocations(Locations locations) {
        this.locations = locations;
        this.locationCode = locations.getCode();
    }
}
