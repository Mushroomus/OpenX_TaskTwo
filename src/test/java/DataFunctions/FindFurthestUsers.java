package DataFunctions;

import org.example.user.User;
import org.example.user.UserAddress;
import org.example.user.UserGeolocation;
import org.example.user.UserName;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.example.utils.DataFunctions.findFurthestUsers;
import static org.junit.Assert.assertEquals;

public class FindFurthestUsers {

    public static String captureOutput(Runnable runnable) {
        final java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        final java.io.PrintStream originalOut = System.out;
        System.setOut(new java.io.PrintStream(outContent));
        runnable.run();
        System.setOut(originalOut);
        return outContent.toString().trim();
    }

    @Test
    public void testFindFurthestUsersEmptyList() {
        List<User> users = Collections.emptyList();

        String expectedOutput = "There are not enough users to find furthest users";
        assertEquals(expectedOutput, captureOutput(() -> findFurthestUsers(users)));
    }

    @Test
    public void testFindFurthestUsersSingleUser() {
        User user1 = new User(1, "user1@example.com", "user1", "password", new UserName("John", "Doe"), "123-456-7890",
                new UserAddress(new UserGeolocation("10.0", "20.0"), "City1", "Street1", 123, "12345"));
        List<User> users = Collections.singletonList(user1);

        String expectedOutput = "There are not enough users to find furthest users";
        assertEquals(expectedOutput, captureOutput(() -> findFurthestUsers(users)));
    }

    @Test
    public void testFindFurthestUsersTwoUsers() {
        User user1 = new User(1, "user1@example.com", "user1", "password", new UserName("John", "Doe"), "123-456-7890",
                new UserAddress(new UserGeolocation("10.0", "20.0"), "City1", "Street1", 123, "12345"));
        User user2 = new User(2, "user2@example.com", "user2", "password", new UserName("Jane", "Doe"), "123-456-7890",
                new UserAddress(new UserGeolocation("-30.0", "-40.0"), "City2", "Street2", 456, "54321"));
        List<User> users = Arrays.asList(user1, user2);

        String expectedOutput = "The furthest users are John Doe and Jane Doe, with a distance of 7799.976537459435 km";
        assertEquals(expectedOutput, captureOutput(() -> findFurthestUsers(users)));
    }

    @Test
    public void testFindFurthestUsersMultipleUsers() {
        User user1 = new User(1, "user1@example.com", "user1", "password", new UserName("John", "Doe"), "123-456-7890",
                new UserAddress(new UserGeolocation("10.0", "20.0"), "City1", "Street1", 123, "12345"));
        User user2 = new User(2, "user2@example.com", "user2", "password", new UserName("Jane", "Doe"), "123-456-7890",
                new UserAddress(new UserGeolocation("-30.0", "-40.0"), "City2", "Street2", 456, "54321"));
        User user3 = new User(3, "user3@example.com", "user3", "password", new UserName("Alice", "Smith"), "123-456-7890",
                new UserAddress(new UserGeolocation("50.0", "-80.0"), "City3", "Street3", 789, "98765"));
        User user4 = new User(4, "user4@example.com", "user4", "password", new UserName("Bob", "Smith"), "123-456-7890",
                new UserAddress(new UserGeolocation("-60.0", "70.0"), "City4", "Street4", 135, "54321"));
        User user5 = new User(5, "user5@example.com", "user5", "password", new UserName("Chris", "Evans"), "123-456-7890",
                new UserAddress(new UserGeolocation("20.0", "-130.0"), "City5", "Street5", 246, "12345"));
        User user6 = new User(6, "user6@example.com", "user6", "password", new UserName("Jennifer", "Lawrence"), "123-456-7890",
                new UserAddress(new UserGeolocation("-40.0", "110.0"), "City6", "Street6", 357, "98765"));

        List<User> users = Arrays.asList(user1, user2, user3, user4, user5, user6);

        String expectedOutput = "The furthest users are Alice Smith and Jennifer Lawrence, with a distance of 18655.83227026523 km";
        assertEquals(expectedOutput, captureOutput(() -> findFurthestUsers(users)));
    }
}
