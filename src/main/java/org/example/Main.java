package org.example;

import org.example.cart.Cart;
import org.example.product.Product;
import org.example.user.User;
import org.example.utils.DataFunctions;

import java.util.List;

import static org.example.utils.FetchData.fetchData;

public class Main {
    public static void main(String[] args) {

        List<User> users = fetchData("https://fakestoreapi.com/users", User[].class);
        List<Cart> carts = fetchData("https://fakestoreapi.com/carts", Cart[].class);
        List<Product> products = fetchData("https://fakestoreapi.com/products", Product[].class);

        for (User user : users) {
            System.out.println(user.getEmail());
        }


        for (Cart cart : carts) {
            System.out.println(cart.getDate());
        }

        for (Product product : products) {
            System.out.println(product.getTitle());
        }

        /*
        Map<String, BigDecimal> taskTwo = Functions.getCategoriesTotalValue(products);

        for (Map.Entry<String, BigDecimal> entry : taskTwo.entrySet()) {
            String key = entry.getKey();
            BigDecimal value = entry.getValue();
            System.out.println(key + " = " + value);
        }
         */

        /*
        Map<String, BigDecimal> taskThree = Functions.getFullNameAndValueOfHighestCart(carts, products, users);

        for (Map.Entry<String, BigDecimal> entry : taskThree.entrySet()) {
            String key = entry.getKey();
            BigDecimal value = entry.getValue();
            System.out.println(key + " = " + value);
        }
         */

        DataFunctions.findFurthestUsers(users);
    }
}