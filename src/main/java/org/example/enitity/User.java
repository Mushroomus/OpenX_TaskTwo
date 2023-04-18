package org.example.enitity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.example.enitity.userEntity.Address;
import org.example.enitity.userEntity.Name;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true) // Ignore __v
public class User {
    private Integer id;
    private String email;
    private String username;
    private String password;
    private Name name;
    private String phone;
    private Address address;
    public User() {}
    public User(Integer id, String email, String username, String password, Name name, String phone, Address address) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof User)) return false;
        User other = (User) o;
        return Objects.equals(this.id, other.id)
                && Objects.equals(this.email, other.email)
                && Objects.equals(this.username, other.username)
                && Objects.equals(this.password, other.password)
                && Objects.equals(this.name, other.name)
                && Objects.equals(this.phone, other.phone)
                && Objects.equals(this.address, other.address);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
