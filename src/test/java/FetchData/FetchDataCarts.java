package FetchData;

import org.example.cart.Cart;
import org.example.cart.CartProduct;
import org.example.utils.FetchData;
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
                                new CartProduct(1, 4),
                                new CartProduct(2, 1),
                                new CartProduct(3, 6)
                        )
                ),
                new Cart(
                        2,
                        1,
                        "2020-01-02T00:00:00.000Z",
                        Arrays.asList(
                                new CartProduct(2, 4),
                                new CartProduct(1, 10),
                                new CartProduct(5, 2)
                        )
                ),
                new Cart(
                        3,
                        2,
                        "2020-03-01T00:00:00.000Z",
                        Arrays.asList(
                                new CartProduct(1, 2),
                                new CartProduct(9, 1)
                        )
                ),
                new Cart(
                        4,
                        3,
                        "2020-01-01T00:00:00.000Z",
                        Arrays.asList(
                                new CartProduct(1, 4)
                        )
                ),
                new Cart(
                        5,
                        3,
                        "2020-03-01T00:00:00.000Z",
                        Arrays.asList(
                                new CartProduct(7, 1),
                                new CartProduct(8, 1)
                        )
                ),
                new Cart(
                        6,
                        4,
                        "2020-03-01T00:00:00.000Z",
                        Arrays.asList(
                                new CartProduct(10, 2),
                                new CartProduct(12, 3)
                        )
                ),
                new Cart(
                        7,
                        8,
                        "2020-03-01T00:00:00.000Z",
                        Arrays.asList(
                                new CartProduct(18, 1)
                        )
                )
        };

        List<Cart> actualCarts = FetchData.fetchData("https://fakestoreapi.com/carts", Cart[].class);
        Cart[] actualCartsArray = actualCarts.toArray(new Cart[actualCarts.size()]);

        for (int i = 0; i < expectedCarts.length; i++) {
            Cart expected = expectedCarts[i];
            Cart actual = actualCartsArray[i];
            assertEquals(expected,actual);
        }
    }
};
