package FetchData;

import org.example.user.User;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNull;

public class FetchData {
    @Test
    public void testFetchDataWithNullURL() {
        List<User> users = org.example.utils.FetchData.fetchData(null, User[].class);
        assertNull(users);
    }

    @Test
    public void testFetchDataWithNullClass() {
        List<User> users = org.example.utils.FetchData.fetchData("https://fakestoreapi.com/users", null);
        assertNull(users);
    }

    @Test
    public void testFetchDataWithEmptyURL() {
        List<User> users = org.example.utils.FetchData.fetchData("", User[].class);
        assertNull(users);
    }


    @Test
    public void testFetchDataWithInvalidURL() {
        List<User> users = org.example.utils.FetchData.fetchData("https://fakestoreapi.com/invalid-url", User[].class);
        assertNull(users);
    }
}
