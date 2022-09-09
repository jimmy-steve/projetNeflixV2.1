package userTest;

import dao.IItem;
import dao.UserDao;
import modeles.User;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UserTest {
    @Test
    public void testInsert() {
        User user = new User("frank", "1234", true);

        IItem userDao = new UserDao();
        userDao.insert(user);
    }

    @Test
    public void testGetAllUsers() {
        UserDao userDao = new UserDao();
        List<User> listUsers = userDao.getAllUsers();

        for (User tmp : listUsers
        ) {
            System.out.println(tmp);
        }
    }

    @Test
    public void testGetUser() {
        UserDao userDao = new UserDao();
        User user = userDao.getUser(2L);

        System.out.println(user);
    }
}
