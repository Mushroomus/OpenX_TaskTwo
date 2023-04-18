package FetchData;

import org.example.enitity.Cart;
import org.example.enitity.CartEntity.Product;
import org.example.enitity.User;
import org.example.utils.FetchDataAPI;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class FetchDataCarts {
    @Test
    public void testFetchDataCarts() {
        Cart[] expectedCarts = {
                new Cart(
                        1,
                        1,
                        "2020-03-02T00:00:00.000Z",
                        Arrays.asList(
                                new Product(1, 4),
                                new Product(2, 1),
                                new Product(3, 6)
                        )
                ),
                new Cart(
                        2,
                        1,
                        "2020-01-02T00:00:00.000Z",
                        Arrays.asList(
                                new Product(2, 4),
                                new Product(1, 10),
                                new Product(5, 2)
                        )
                ),
                new Cart(
                        3,
                        2,
                        "2020-03-01T00:00:00.000Z",
                        Arrays.asList(
                                new Product(1, 2),
                                new Product(9, 1)
                        )
                ),
                new Cart(
                        4,
                        3,
                        "2020-01-01T00:00:00.000Z",
                        Arrays.asList(
                                new Product(1, 4)
                        )
                ),
                new Cart(
                        5,
                        3,
                        "2020-03-01T00:00:00.000Z",
                        Arrays.asList(
                                new Product(7, 1),
                                new Product(8, 1)
                        )
                ),
                new Cart(
                        6,
                        4,
                        "2020-03-01T00:00:00.000Z",
                        Arrays.asList(
                                new Product(10, 2),
                                new Product(12, 3)
                        )
                ),
                new Cart(
                        7,
                        8,
                        "2020-03-01T00:00:00.000Z",
                        Arrays.asList(
                                new Product(18, 1)
                        )
                )
        };

        List<Cart> actualCarts = FetchDataAPI.fetchData("https://fakestoreapi.com/carts", Cart[].class);
        Cart[] actualCartsArray = actualCarts.toArray(new Cart[actualCarts.size()]);

        for (int i = 0; i < expectedCarts.length; i++) {
            Cart expected = expectedCarts[i];
            Cart actual = actualCartsArray[i];
            assertEquals(expected,actual);
        }
    }
};
