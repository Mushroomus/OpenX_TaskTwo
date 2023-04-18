package org.example.utils;

import org.example.enitity.Cart;
import org.example.enitity.Product;
import org.example.enitity.User;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Functions {
    public static Map<String, BigDecimal> getCategoriesTotalValue(List<Product> products) {
        Map<String,BigDecimal> categoriesTotalValue = new HashMap<>();

        for(Product product : products) {
            String category = product.getCategory();
            if(categoriesTotalValue.containsKey(category)) {
                categoriesTotalValue.put(category, categoriesTotalValue.get(category).add(product.getPrice()));
            } else {
                categoriesTotalValue.put(category, product.getPrice());
            }
        }
        return  categoriesTotalValue;
    }

    public static Map<String, BigDecimal> getFullNameAndValueOfHighestCart(List<Cart> carts, List<Product> products, List<User> users) {
        Map<String, BigDecimal> result = new HashMap<>();

        if(carts.isEmpty() || products.isEmpty() || users.isEmpty())
            return result;

        BigDecimal highestTotalValue = BigDecimal.valueOf(0);
        Integer highestCartId = -1;

        for(Cart cart : carts) {
           BigDecimal totalValue = BigDecimal.valueOf(0);

            for (org.example.enitity.CartEntity.Product product : cart.getProducts()) {
                BigDecimal price = products.get(product.getProductId() - 1).getPrice();
                BigDecimal quantity = BigDecimal.valueOf(product.getQuantity());
                totalValue = totalValue.add(price.multiply(quantity));
            }
            totalValue = totalValue.setScale(2, RoundingMode.HALF_UP);

            if (totalValue.compareTo(highestTotalValue) > 0) {
                highestTotalValue = totalValue;
                highestCartId = cart.getId();
            }
        }

        String highestTotalValueName = users.get(carts.get(highestCartId - 1).getUserId() - 1).getName().toString();
        result.put(highestTotalValueName, highestTotalValue);
        return result;
    }


    public static BigDecimal calculateDistance(String lat1, String lon1, String lat2, String lon2) {
        double R = 6371.0;
        double lat1_rad = Math.toRadians(Double.parseDouble(lat1));
        double lon1_rad = Math.toRadians(Double.parseDouble(lon1));
        double lat2_rad = Math.toRadians(Double.parseDouble(lat2));
        double lon2_rad = Math.toRadians(Double.parseDouble(lon2));
        double dlat = lat2_rad - lat1_rad;
        double dlon = lon2_rad - lon1_rad;
        double a = Math.sin(dlat / 2) * Math.sin(dlat / 2) +
                Math.cos(lat1_rad) * Math.cos(lat2_rad) *
                        Math.sin(dlon / 2) * Math.sin(dlon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance_km = R * c;
        return BigDecimal.valueOf(distance_km);
    }


    public static void findFurthestUsers(List<User> users) {

        if(users.size() < 2) {
            System.out.println("There are not enough users to find furthest users");
            return;
        }

        Map<List<User>, BigDecimal> distances = new HashMap<>();
        for (int i = 0; i < users.size(); i++) {
            for (int j = i + 1; j < users.size(); j++) {
                User user1 = users.get(i);
                User user2 = users.get(j);
                BigDecimal distance = calculateDistance(user1.getAddress().getGeolocation().getLat(), user1.getAddress().getGeolocation().getLongitude(),
                        user2.getAddress().getGeolocation().getLat(), user2.getAddress().getGeolocation().getLongitude());
                distances.put(Arrays.asList(user1, user2), distance);
            }
        }

        List<User> furthestUsers = Collections.emptyList();
        BigDecimal maxDistance = BigDecimal.ZERO;
        for (Map.Entry<List<User>, BigDecimal> entry : distances.entrySet()) {
            if (entry.getValue().compareTo(maxDistance) > 0) {
                maxDistance = entry.getValue();
                furthestUsers = entry.getKey();
            }
        }
        System.out.printf("The furthest users are %s and %s, with a distance of %s km",
                furthestUsers.get(0).getName(), furthestUsers.get(1).getName(), maxDistance);
    }
}
