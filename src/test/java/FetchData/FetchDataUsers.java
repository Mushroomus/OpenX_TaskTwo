package FetchData;

import org.example.user.User;
import org.example.user.UserAddress;
import org.example.user.UserGeolocation;
import org.example.user.UserName;
import org.example.utils.FetchData;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FetchDataUsers {
    @Test
    public void testFetchDataUsers() {
        User[] expectedUsers = {
                new User(
                        1,
                        "john@gmail.com",
                        "johnd",
                        "m38rmF$",
                        new UserName("john", "doe"),
                        "1-570-236-7033",
                        new UserAddress(
                                new UserGeolocation("-37.3159", "81.1496"),
                                "kilcoole",
                                "new road",
                                7682,
                                "12926-3874"
                        )
                ),
                new User(
                        2,
                        "morrison@gmail.com",
                        "mor_2314",
                        "83r5^_",
                        new UserName("david", "morrison"),
                        "1-570-236-7033",
                        new UserAddress(
                                new UserGeolocation("-37.3159", "81.1496"),
                                "kilcoole",
                                "Lovers Ln",
                                7267,
                                "12926-3874"
                        )
                ),
                new User(
                        3,
                        "kevin@gmail.com",
                        "kevinryan",
                        "kev02937@",
                        new UserName("kevin", "ryan"),
                        "1-567-094-1345",
                        new UserAddress(
                                new UserGeolocation("40.3467", "-30.1310"),
                                "Cullman",
                                "Frances Ct",
                                86,
                                "29567-1452"
                        )
                ),
                new User(
                        4,
                        "don@gmail.com",
                        "donero",
                        "ewedon",
                        new UserName("don", "romer"),
                        "1-765-789-6734",
                        new UserAddress(
                                new UserGeolocation("50.3467", "-20.1310"),
                                "San Antonio",
                                "Hunters Creek Dr",
                                6454,
                                "98234-1734"
                        )
                ),
                new User(
                        5,
                        "derek@gmail.com",
                        "derek",
                        "jklg*_56",
                        new UserName("derek", "powell"),
                        "1-956-001-1945",
                        new UserAddress(
                                new UserGeolocation("40.3467", "-40.1310"),
                                "san Antonio",
                                "adams St",
                                245,
                                "80796-1234"
                        )
                ),
                new User(
                        6,
                        "david_r@gmail.com",
                        "david_r",
                        "3478*#54",
                        new UserName("david", "russell"),
                        "1-678-345-9856",
                        new UserAddress(
                                new UserGeolocation("20.1677", "-10.6789"),
                                "el paso",
                                "prospect st",
                                124,
                                "12346-0456"
                        )
                ),
                new User(
                        7,
                        "miriam@gmail.com",
                        "snyder",
                        "f238&@*$",
                        new UserName("miriam", "snyder"),
                        "1-123-943-0563",
                        new UserAddress(
                                new UserGeolocation("10.3456", "20.6419"),
                                "fresno",
                                "saddle st",
                                1342,
                                "96378-0245"
                        )
                ),
                new User(
                        8,
                        "william@gmail.com",
                        "hopkins",
                        "William56$hj",
                        new UserName("william", "hopkins"),
                        "1-478-001-0890",
                        new UserAddress(
                                new UserGeolocation("50.3456", "10.6419"),
                                "mesa",
                                "vally view ln",
                                1342,
                                "96378-0245"
                        )
                ),
                new User(
                        9,
                        "kate@gmail.com",
                        "kate_h",
                        "kfejk@*_",
                        new UserName("kate", "hale"),
                        "1-678-456-1934",
                        new UserAddress(
                                new UserGeolocation("40.12456", "20.5419"),
                                "miami",
                                "avondale ave",
                                345,
                                "96378-0245"
                        )
                ),
                new User(
                        10,
                        "jimmie@gmail.com",
                        "jimmie_k",
                        "klein*#%*",
                        new UserName("jimmie", "klein"),
                        "1-104-001-4567",
                        new UserAddress(
                                new UserGeolocation("30.24788", "-20.545419"),
                                "fort wayne",
                                "oak lawn ave",
                                526,
                                "10256-4532"
                        )
                ),
        };

        List<User> actualUsers = FetchData.fetchData("https://fakestoreapi.com/users", User[].class);
        User[] actualUsersArray = actualUsers.toArray(new User[actualUsers.size()]);

        for (int i = 0; i < expectedUsers.length; i++) {
            User expected = expectedUsers[i];
            User actual = actualUsersArray[i];
            assertEquals(expected,actual);
        }
    }

    @Test
    public void testAmountFetchUsers() {
        List<User> users = FetchData.fetchData("https://fakestoreapi.com/users", User[].class);
        assertNotNull(users);
        assertEquals(10, users.size());
    }
}
