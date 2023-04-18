package org.example.enitity.userEntity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class Geolocation {
    private String lat;
    @JsonProperty("long")
    private String longitude;
    public Geolocation() {}
    public Geolocation(String lat, String longitude) {
        this.lat = lat;
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Geolocation that = (Geolocation) o;
        return Objects.equals(lat, that.lat) && Objects.equals(longitude, that.longitude);
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
