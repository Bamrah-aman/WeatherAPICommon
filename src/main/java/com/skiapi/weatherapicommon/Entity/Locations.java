package com.skiapi.weatherapicommon.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "locations")
public class Locations {

    public Locations(String cityName, String regionName, String countryName, String countryCode) {
        this.cityName = cityName;
        this.regionName = regionName;
        this.countryName = countryName;
        this.countryCode = countryCode;
    }

    @Column(length = 12, nullable = false, unique = true)
    @Id
    @NotBlank(message = "Location code cannot be left blank")
    @JsonProperty("code")
    @Length(min = 3, max = 12, message = "Location code must be 3-12 of length")
    private String code;

    @Column(length = 128, nullable = false)
    @NotBlank(message = "City-name cannot be left blank")
    @JsonProperty("city_name")
    @Length(min = 3, max = 128, message = "City-name must be 3-128 of length")
    private String cityName;

    @Column(length = 128, nullable = true)
    @JsonProperty("region_name")
    private String regionName;

    @Column(length = 64, nullable = false)
    @NotBlank(message = "Country-name cannot be left blank")
    @JsonProperty("country_name")
    @Length(min = 3, max = 64, message = "Country-name must be 3-12 of length")
    private String countryName;

    @Column(length = 2, nullable = false)
    @NotBlank(message = "Country-code cannot be left blank")
    @JsonProperty("country_code")
    @Length(min = 2, max = 2, message = "Country code must be 3-12 of length")
    private String countryCode;

    @JsonIgnore
    private boolean enabled = true;

    @JsonIgnore
    private boolean trashed;

    @OneToOne(mappedBy = "locations", cascade = CascadeType.ALL)
    @JsonIgnore
    private RealtimeWeather realtimeWeather;

    @Override
    public String toString() {
        return cityName+", "+countryName;
    }
}
