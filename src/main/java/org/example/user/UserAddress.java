package org.example.user;

import java.util.Objects;

public class UserAddress {
    private UserGeolocation userGeolocation;
    private String city;
    private String street;
    private Integer number;
    private String zipcode;

    public UserAddress() {}
    public UserAddress(UserGeolocation userGeolocation, String city, String street, Integer number, String zipcode) {
        this.userGeolocation = userGeolocation;
        this.city = city;
        this.street = street;
        this.number = number;
        this.zipcode = zipcode;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof UserAddress)) {
            return false;
        }

        UserAddress other = (UserAddress) obj;

        return Objects.equals(this.userGeolocation, other.userGeolocation)
                && Objects.equals(this.city, other.city)
                && Objects.equals(this.street, other.street)
                && Objects.equals(this.number, other.number)
                && Objects.equals(this.zipcode, other.zipcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userGeolocation, city, street, number, zipcode);
    }

    public UserGeolocation getGeolocation() {
        return userGeolocation;
    }

    public void setGeolocation(UserGeolocation userGeolocation) {
        this.userGeolocation = userGeolocation;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
