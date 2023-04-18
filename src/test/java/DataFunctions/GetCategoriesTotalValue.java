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
                "Title",
                new BigDecimal("109.95"),
                "Description",
                "Category 1",
                "image 1",
                new ProductRating(3.9, 120)
        ));
        Map<String, BigDecimal> categoriesTotalValue = DataFunctions.getCategoriesTotalValue(products);
        assertEquals(1, categoriesTotalValue.size());
        assertEquals(new BigDecimal("109.95"), categoriesTotalValue.get("Category 1"));
    }

    @Test
    public void testGetCategoriesTotalValueWithMultipleProductsInSameCategory() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(
                1,
                "Title 1",
                new BigDecimal("109.95"),
                "Description 1",
                "Category 1",
                "Image 1",
                new ProductRating(3.9, 120)
        ));
        products.add(new Product(
                2,
                "Title 2",
                new BigDecimal("22.3"),
                "Description 2",
                "Category 1",
                "Image 2",
                new ProductRating(4.1, 259)
        ));
        Map<String, BigDecimal> categoriesTotalValue = DataFunctions.getCategoriesTotalValue(products);
        assertEquals(1, categoriesTotalValue.size());
        assertEquals(new BigDecimal("132.25"), categoriesTotalValue.get("Category 1"));
    }

    @Test
    public void testGetCategoriesTotalValueWithDifferentCategoryProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(
                1,
                "Title 1",
                new BigDecimal("109.95"),
                "Description 1",
                "Category 1",
                "Image 1",
                new ProductRating(3.9, 120)
                )
        );
        products.add(new Product(
                        2,
                        "Title 2",
                        new BigDecimal("695"),
                        "Description 2",
                        "Category 2",
                        "Image 2",
                        new ProductRating(4.6, 400)
                )
        );
        products.add(new Product(9,
                        "Title 3",
                        new BigDecimal("64"),
                        "Description 3",
                        "Category 3",
                        "Image 3",
                        new ProductRating(3.3, 203)
                )
        );

        Map<String, BigDecimal> result = DataFunctions.getCategoriesTotalValue(products);

        assertTrue(result.containsKey("Category 1"));
        assertEquals(new BigDecimal("109.95"), result.get("Category 1"));

        assertTrue(result.containsKey("Category 2"));
        assertEquals(new BigDecimal("695"), result.get("Category 2"));

        assertTrue(result.containsKey("Category 3"));
        assertEquals(new BigDecimal("64"), result.get("Category 3"));
    }

    @Test
    public void testGetCategoriesTotalValue() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(
                1,
                "Title 1",
                new BigDecimal("109.95"),
                "Description 1",
                "Category 1",
                "Image 1",
                new ProductRating(3.9, 120)
        ));
        products.add(new Product(
                2,
                "Title 2",
                new BigDecimal("22.3"),
                "Description 2",
                "Category 1",
                "Image 2",
                new ProductRating(4.1, 259)
        ));
        products.add(new Product(
                3,
                "Title 3",
                new BigDecimal("55.99"),
                "Description 3",
                "Category 1",
                "Image 3",
                new ProductRating(4.7, 500)
        ));
        products.add(new Product(
                4,
                "Title 4",
                new BigDecimal("48.99"),
                "Description 4",
                "Category 2",
                "Image 4",
                new ProductRating(4.5, 222)
        ));
        products.add(new Product(
                5,
                "Title 5",
                new BigDecimal("29.99"),
                "Description 5",
                "Category 2",
                "Image 5",
                new ProductRating(3.9, 201)
        ));

        Map<String, BigDecimal> result = DataFunctions.getCategoriesTotalValue(products);

        assertEquals(new BigDecimal("188.24"), result.get("Category 1"));
        assertEquals(new BigDecimal("78.98"), result.get("Category 2"));
    }
}
