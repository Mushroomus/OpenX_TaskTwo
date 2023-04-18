package DataFunctions;

import org.example.product.Product;
import org.example.product.ProductRating;
import org.example.utils.DataFunctions;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetCategoriesTotalValue {

    @Test
    public void testGetCategoriesTotalValueEmptyProductList() {
        List<Product> products = new ArrayList<>();
        Map<String, BigDecimal> categoriesTotalValue = DataFunctions.getCategoriesTotalValue(products);
        assertEquals(0, categoriesTotalValue.size());
    }

    @Test
    public void testGetCategoriesTotalValueWithOneProduct() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(
                1,
                "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
                new BigDecimal("109.95"),
                "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
                "men's clothing",
                "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
                new ProductRating(3.9, 120)
        ));
        Map<String, BigDecimal> categoriesTotalValue = DataFunctions.getCategoriesTotalValue(products);
        assertEquals(1, categoriesTotalValue.size());
        assertEquals(new BigDecimal("109.95"), categoriesTotalValue.get("men's clothing"));
    }

    @Test
    public void testGetCategoriesTotalValueWithMultipleProductsInSameCategory() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(
                1,
                "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
                new BigDecimal("109.95"),
                "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
                "men's clothing",
                "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
                new ProductRating(3.9, 120)
        ));
        products.add(new Product(
                2,
                "Mens Casual Premium Slim Fit T-Shirts ",
                new BigDecimal("22.3"),
                "Slim-fitting style, contrast raglan long sleeve, three-button henley placket, light weight & soft fabric for breathable and comfortable wearing.",
                "men's clothing",
                "https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_.jpg",
                new ProductRating(4.1, 259)
        ));
        Map<String, BigDecimal> categoriesTotalValue = DataFunctions.getCategoriesTotalValue(products);
        assertEquals(1, categoriesTotalValue.size());
        assertEquals(new BigDecimal("132.25"), categoriesTotalValue.get("men's clothing"));
    }

    @Test
    public void testGetCategoriesTotalValueWithDifferentCategoryProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(
                1,
                "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
                new BigDecimal("109.95"),
                "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
                "men's clothing",
                "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
                new ProductRating(3.9, 120)
                )
        );
        products.add(new Product(
                        2,
                        "John Hardy Women's Legends Naga Gold & Silver Dragon Station Chain Bracelet",
                        new BigDecimal("695"),
                        "From our Legends Collection, the Naga was inspired by the mythical water dragon that protects the ocean's pearl. Wear facing inward to be bestowed with love and abundance, or outward for protection.",
                        "jewelery",
                        "https://fakestoreapi.com/img/71pWzhdJNwL._AC_UL640_QL65_ML3_.jpg",
                        new ProductRating(4.6, 400)
                )
        );
        products.add(new Product(9,
                        "WD 2TB Elements Portable External Hard Drive - USB 3.0 ",
                        new BigDecimal("64"),
                        "USB 3.0 and USB 2.0 Compatibility Fast data transfers Improve PC Performance High Capacity; Compatibility Formatted NTFS for Windows 10, Windows 8.1, Windows 7; Reformatting may be required for other operating systems; Compatibility may vary depending on user’s hardware configuration and operating system",
                        "electronics",
                        "https://fakestoreapi.com/img/61IBBVJvSDL._AC_SY879_.jpg",
                        new ProductRating(3.3, 203)
                )
        );

        Map<String, BigDecimal> result = DataFunctions.getCategoriesTotalValue(products);

        assertTrue(result.containsKey("men's clothing"));
        assertEquals(new BigDecimal("109.95"), result.get("men's clothing"));

        assertTrue(result.containsKey("jewelery"));
        assertEquals(new BigDecimal("695"), result.get("jewelery"));

        assertTrue(result.containsKey("electronics"));
        assertEquals(new BigDecimal("64"), result.get("electronics"));
    }

    @Test
    public void testGetCategoriesTotalValue() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(
                1,
                "Fjallraven - Foldsack No. 1 Backpack, Fits 15 Laptops",
                new BigDecimal("109.95"),
                "Your perfect pack for everyday use and walks in the forest. Stash your laptop (up to 15 inches) in the padded sleeve, your everyday",
                "men's clothing",
                "https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg",
                new ProductRating(3.9, 120)
        ));
        products.add(new Product(
                2,
                "Mens Casual Premium Slim Fit T-Shirts ",
                new BigDecimal("22.3"),
                "Slim-fitting style, contrast raglan long sleeve, three-button henley placket, light weight & soft fabric for breathable and comfortable wearing.",
                "men's clothing",
                "https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_.jpg",
                new ProductRating(4.1, 259)
        ));
        products.add(new Product(
                3,
                "Mens Cotton Jacket",
                new BigDecimal("55.99"),
                "Great for wearing in casual settings or for outdoor activities, this jacket is made of cotton and features a zip-up front and multiple pockets.",
                "men's clothing",
                "https://fakestoreapi.com/img/71li-ujtlUL._AC_UX679_.jpg",
                new ProductRating(4.7, 500)
        ));
        products.add(new Product(
                4,
                "Womens Stylish Striped Long Sleeve Button-Down Shirt",
                new BigDecimal("48.99"),
                "This shirt features a stylish striped pattern, a button-down front, and a long sleeve design that is perfect for cooler weather.",
                "women's clothing",
                "https://fakestoreapi.com/img/8RGB8A3NfNECstyBkN3WPnA-v9-70.jpg",
                new ProductRating(4.5, 222)
        ));
        products.add(new Product(
                5,
                "Womens Boho Floral Print Chiffon Dress",
                new BigDecimal("29.99"),
                "This beautiful dress features a boho floral print, a chiffon material, and a comfortable fit that is perfect for any occasion.",
                "women's clothing",
                "https://fakestoreapi.com/img/51eg55uWmdL._AC_UX679_.jpg",
                new ProductRating(3.9, 201)
        ));

        Map<String, BigDecimal> result = DataFunctions.getCategoriesTotalValue(products);

        assertEquals(new BigDecimal("188.24"), result.get("men's clothing"));
        assertEquals(new BigDecimal("78.98"), result.get("women's clothing"));
    }
}
