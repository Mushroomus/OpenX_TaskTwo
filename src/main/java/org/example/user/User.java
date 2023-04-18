package org.example.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true) // Ignore __v
public class User {
    private Integer id;
    private String email;
    private String username;
    private String password;
    private UserName userName;
    private String phone;
    private UserAddress userAddress;
    public User() {}
    public User(Integer id, String email, String username, String password, UserName userName, String phone, UserAddress userAddress) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
        this.userName = userName;
        this.phone = phone;
        this.userAddress = userAddress;
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
                && Objects.equals(this.userName, other.userName)
                && Objects.equals(this.phone, other.phone)
                && Objects.equals(this.userAddress, other.userAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, username, password, userName, phone, userAddress);
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

    public UserName getName() {
        return userName;
    }

    public void setName(UserName userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserAddress getAddress() {
        return userAddress;
    }

    public void setAddress(UserAddress userAddress) {
        this.userAddress = userAddress;
    }
}
