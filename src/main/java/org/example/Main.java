package org.example;

import org.example.cart.Cart;
import org.example.product.Product;
import org.example.user.User;
import org.example.utils.DataFunctions;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static org.example.utils.FetchData.fetchData;

public class Main {
    public static void main(String[] args) {

        List<User> users = fetchData("https://fakestoreapi.com/users", User[].class);
        List<Cart> carts = fetchData("https://fakestoreapi.com/carts", Cart[].class);
        List<Product> products = fetchData("https://fakestoreapi.com/products", Product[].class);


        Map<String, BigDecimal> taskTwo = DataFunctions.getCategoriesTotalValue(products);

        System.out.println("Categories Total Values Products");
        for (Map.Entry<String, BigDecimal> entry : taskTwo.entrySet()) {
            String key = entry.getKey();
            BigDecimal value = entry.getValue();
            System.out.println(key + " " + value);
        }
        System.out.println();


        Map<String, BigDecimal> taskThree = DataFunctions.getFullNameAndValueOfHighestCart(carts, products, users);

        System.out.println("Highest Cart Value User");
        for (Map.Entry<String, BigDecimal> entry : taskThree.entrySet()) {
            String key = entry.getKey();
            BigDecimal value = entry.getValue();
            System.out.println(key + " " + value);
        }
        System.out.println();

        DataFunctions.findFurthestUsers(users);
    }
}