package userTest;

import dao.IUserDao;
import dao.UserDao;
import modeles.User;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UserTest {
    @Test
    public void testInsert() {
        User user = new User("frank", "1234", true);

        IUserDao userDao = new UserDao();
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
        IUserDao iUserDao = new UserDao();
        User user = iUserDao.getUser(2L);

        System.out.println(user);
    }

    @Test
    public void testUpdateUser() {
        IUserDao iUserDao = new UserDao();
        User user = iUserDao.getUser(5L);

        System.out.println(user);

        String username = "Salut";

        boolean resultat = iUserDao.updateUser(user.getIdUser(),username);

        User userAfter = iUserDao.getUser(5L);
        System.out.println(userAfter);

        System.out.println(resultat);
    }
}
