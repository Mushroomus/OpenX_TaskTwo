package org.example.product;

import java.util.Objects;

public class ProductRating {
    private Double rate;
    private Integer count;

    ProductRating() {}

    public ProductRating(Double rate, Integer count) {
        this.rate = rate;
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ProductRating)) {
            return false;
        }
        ProductRating other = (ProductRating) o;
        return Objects.equals(rate, other.rate) && Objects.equals(count, other.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rate, count);
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
