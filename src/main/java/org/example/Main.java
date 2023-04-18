package org.example;

import org.example.enitity.Cart;
import org.example.enitity.Product;
import org.example.enitity.User;
import org.example.utils.FetchDataAPI;
import org.example.utils.Functions;

import java.math.BigDecimal;
import java.nio.DoubleBuffer;
import java.util.List;
import java.util.Map;

import static org.example.utils.FetchDataAPI.fetchData;

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

        Functions.findFurthestUsers(users);
    }
}