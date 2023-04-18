package org.example.cart;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true) // Ignore __v
public class Cart {
    private Integer id;
    private Integer userId;
    private String date;
    private List<CartProduct> cartProducts;

    Cart() {}

    public Cart(Integer id, Integer userId, String date, List<CartProduct> cartProducts) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.cartProducts = cartProducts;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Cart)) {
            return false;
        }
        Cart cart = (Cart) o;
        return Objects.equals(id, cart.id) &&
                Objects.equals(userId, cart.userId) &&
                Objects.equals(date, cart.date) &&
                Objects.equals(cartProducts, cart.cartProducts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, date, cartProducts);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<CartProduct> getProducts() {
        return cartProducts;
    }

    public void setProducts(List<CartProduct> cartProducts) {
        this.cartProducts = cartProducts;
    }
}
