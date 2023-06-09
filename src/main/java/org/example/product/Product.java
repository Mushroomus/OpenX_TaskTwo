package org.example.product;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private Integer id;
    private String title;
    private BigDecimal price;
    private String description;
    private String category;
    private String image;
    private ProductRating productRating;

    Product() {}

    public Product(Integer id, String title, BigDecimal price, String description, String category, String image, ProductRating productRating) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.description = description;
        this.category = category;
        this.image = image;
        this.productRating = productRating;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Product)) {
            return false;
        }
        Product other = (Product) obj;
        return Objects.equals(id, other.id) &&
                Objects.equals(title, other.title) &&
                Objects.equals(price, other.price) &&
                Objects.equals(description, other.description) &&
                Objects.equals(category, other.category) &&
                Objects.equals(image, other.image) &&
                Objects.equals(productRating, other.productRating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price, description, category, image, productRating);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ProductRating getRating() {
        return productRating;
    }

    public void setRating(ProductRating productRating) {
        this.productRating = productRating;
    }
}
