package org.example.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class UserGeolocation {
    private String lat;
    @JsonProperty("long")
    private String longitude;
    public UserGeolocation() {}
    public UserGeolocation(String lat, String longitude) {
        this.lat = lat;
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserGeolocation that = (UserGeolocation) o;
        return Objects.equals(lat, that.lat) && Objects.equals(longitude, that.longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lat, longitude);
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
