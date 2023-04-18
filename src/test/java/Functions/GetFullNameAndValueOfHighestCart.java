package Functions;

import org.example.enitity.Cart;
import org.example.enitity.Product;
import org.example.enitity.User;
import org.example.enitity.productEntity.Rating;
import org.example.enitity.userEntity.Address;
import org.example.enitity.userEntity.Geolocation;
import org.example.enitity.userEntity.Name;
import org.example.utils.Functions;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class GetFullNameAndValueOfHighestCart {

    @Test
    public void testGetFullNameAndValueOfHighestCartEmptyLists() {
        List<Product> products = Collections.emptyList();
        List<User> users = Collections.emptyList();
        List<Cart> carts = Collections.emptyList();
        Map<String, BigDecimal> result = Functions.getFullNameAndValueOfHighestCart(carts, products, users);
        assertEquals(0, result.size());
    }

    @Test
    public void testGetFullNameAndValueOfHighestCartEmptyCarts() {
        List<Product> products = Arrays.asList(
                new Product(1, "Product 1", new BigDecimal("1.99"), "Description 1", "category 1", "image 1", new Rating(4.2, 100)),
                new Product(2, "Product 2", new BigDecimal("2.99"), "Description 2", "category 2", "image 2", new Rating(3.5, 50)),
                new Product(3, "Product 3", new BigDecimal("3.99"), "Description 3", "category 1", "image 3", new Rating(4.8, 200))
        );

        List<User> users = Arrays.asList(
                new User(1, "user1@example.com", "user1", "password", new Name("John", "Doe"), "123-456-7890", new Address(new Geolocation("10.0", "20.0"), "City1", "Street1", 123, "12345"))
        );

        List<Cart> carts = Collections.emptyList();

        Map<String, BigDecimal> result = Functions.getFullNameAndValueOfHighestCart(carts, products, users);

        assertEquals(0, result.size());
    }

    @Test
    public void testGetFullNameAndValueOfHighestCartOneCart() {
        List<Product> products = Arrays.asList(
                new Product(1, "Product 1", new BigDecimal("1.99"), "Description 1", "category 1", "image 1", new Rating(4.2, 100)),
                new Product(2, "Product 2", new BigDecimal("2.99"), "Description 2", "category 2", "image 2", new Rating(3.5, 50))
        );
        List<User> users = Arrays.asList(
                new User(1, "user1@example.com", "user1", "password", new Name("John", "Doe"), "123-456-7890", new Address(new Geolocation("10.0", "20.0"), "City1", "Street1", 123, "12345"))
        );
        List<Cart> carts = Arrays.asList(
                new Cart(1, 1, "2020-03-02T00:00:00.000Z", Arrays.asList(
                        new org.example.enitity.CartEntity.Product(1, 4),
                        new org.example.enitity.CartEntity.Product(2, 1)
                ))
        );
        Map<String, BigDecimal> result = Functions.getFullNameAndValueOfHighestCart(carts, products, users);
        assertEquals(1, result.size());
        assertEquals(new BigDecimal("10.95"), result.get("John Doe"));
    }

    @Test
    public void testGetFullNameAndValueOfHighestCartOneUser() {
        List<Product> products = Arrays.asList(
                new Product(1, "Product 1", new BigDecimal("1.99"), "Description 1", "category 1", "image 1", new Rating(4.2, 100)),
                new Product(2, "Product 2", new BigDecimal("2.99"), "Description 2", "category 2", "image 2", new Rating(3.5, 50)),
                new Product(3, "Product 3", new BigDecimal("3.99"), "Description 3", "category 1", "image 3", new Rating(4.8, 200))
        );

        List<User> users = Arrays.asList(
                new User(1, "user1@example.com", "user1", "password", new Name("John", "Doe"), "123-456-7890", new Address(new Geolocation("10.0", "20.0"), "City1", "Street1", 123, "12345"))
        );

        List<Cart> carts = Arrays.asList(
                new Cart(1, 1, "2020-03-02T00:00:00.000Z", Arrays.asList(
                        new org.example.enitity.CartEntity.Product(1, 4),
                        new org.example.enitity.CartEntity.Product(2, 1),
                        new org.example.enitity.CartEntity.Product(3, 6)
                )),
                new Cart(2, 1, "2020-03-03T00:00:00.000Z", Arrays.asList(
                        new org.example.enitity.CartEntity.Product(2, 2),
                        new org.example.enitity.CartEntity.Product(3, 3)
                ))
        );

        Map<String, BigDecimal> result = Functions.getFullNameAndValueOfHighestCart(carts, products, users);
        for (String key : result.keySet()) {
            BigDecimal value = result.get(key);
            System.out.println(key + " -> " + value);
        }

        assertEquals(1, result.size());
        assertEquals(new BigDecimal("34.89"), result.get("John Doe"));
    }

    @Test
    public void testGetFullNameAndValueOfHighestCartMultipleCartsWithSameValue() {
        List<Product> products = Arrays.asList(
                new Product(1, "Product 1", new BigDecimal("1.99"), "Description 1", "category 1", "image 1", new Rating(4.2, 100)),
                new Product(2, "Product 2", new BigDecimal("2.99"), "Description 2", "category 2", "image 2", new Rating(3.5, 50)),
                new Product(3, "Product 3", new BigDecimal("3.99"), "Description 3", "category 1", "image 3", new Rating(4.8, 200))
        );

        List<User> users = Arrays.asList(
                new User(1, "user1@example.com", "user1", "password", new Name("John", "Doe"), "123-456-7890", new Address(new Geolocation("10.0", "20.0"), "City1", "Street1", 123, "12345")),
                new User(2, "user2@example.com", "user2", "password", new Name("Jane", "Doe"), "123-456-7890", new Address(new Geolocation("20.0", "30.0"), "City2", "Street2", 456, "54321"))
        );

        List<Cart> carts = Arrays.asList(
                new Cart(1, 1, "2020-03-02T00:00:00.000Z", Arrays.asList(
                        new org.example.enitity.CartEntity.Product(1, 2),
                        new org.example.enitity.CartEntity.Product(2, 1),
                        new org.example.enitity.CartEntity.Product(3, 3)
                )),
                new Cart(2, 2, "2020-03-03T00:00:00.000Z", Arrays.asList(
                        new org.example.enitity.CartEntity.Product(2, 2),
                        new org.example.enitity.CartEntity.Product(3, 1)
                )),
                new Cart(3, 1, "2020-03-04T00:00:00.000Z", Arrays.asList(
                        new org.example.enitity.CartEntity.Product(1, 3),
                        new org.example.enitity.CartEntity.Product(3, 2)
                ))
        );

        Map<String, BigDecimal> result = Functions.getFullNameAndValueOfHighestCart(carts, products, users);
        assertEquals(new BigDecimal("18.94"), result.get("John Doe"));
    }


    @Test
    public void testGetFullNameAndValueOfHighestCart() {
        List<Product> products = Arrays.asList(
                new Product(1, "Product 1", new BigDecimal("1.99"), "Description 1", "category 1", "image 1", new Rating(4.2, 100)),
                new Product(2, "Product 2", new BigDecimal("2.99"), "Description 2", "category 2", "image 2", new Rating(3.5, 50)),
                new Product(3, "Product 3", new BigDecimal("3.99"), "Description 3", "category 1", "image 3", new Rating(4.8, 200))
        );

        List<User> users = Arrays.asList(
                new User(1, "user1@example.com", "user1", "password", new Name("John", "Doe"), "123-456-7890", new Address(new Geolocation("10.0", "20.0"), "City1", "Street1", 123, "12345")),
                new User(2, "user2@example.com", "user2", "password", new Name("Jane", "Doe"), "123-456-7890", new Address(new Geolocation("20.0", "30.0"), "City2", "Street2", 456, "54321"))
        );

        List<Cart> carts = Arrays.asList(
                new Cart(1, 1, "2020-03-02T00:00:00.000Z", Arrays.asList(
                        new org.example.enitity.CartEntity.Product(1, 4),
                        new org.example.enitity.CartEntity.Product(2, 1),
                        new org.example.enitity.CartEntity.Product(3, 6)
                )),
                new Cart(2, 2, "2020-03-03T00:00:00.000Z", Arrays.asList(
                        new org.example.enitity.CartEntity.Product(2, 2),
                        new org.example.enitity.CartEntity.Product(3, 3)
                ))
        );

        Map<String, BigDecimal> result = Functions.getFullNameAndValueOfHighestCart(carts, products, users);
        for (String key : result.keySet()) {
            BigDecimal value = result.get(key);
            System.out.println(key + " -> " + value);
        }

        assertEquals(1, result.size());
        assertEquals(new BigDecimal("34.89"), result.get("John Doe"));
    }


}
