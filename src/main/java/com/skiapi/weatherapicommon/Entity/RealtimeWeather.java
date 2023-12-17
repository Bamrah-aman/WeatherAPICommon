package com.skiapi.weatherapicommon.Entity;

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
    private int windSpeed;

    @Column(length = 50)
    private String status;
    private LocalDateTime lastUpdated;

    @OneToOne
    @MapsId //When you want to share the primary key between the two entities
    @JoinColumn(name = "location_code")
    private Locations locations;

    public void setLocations(Locations locations) {
        this.locations = locations;
        this.locationCode = locations.getCode();
    }
}
