package dao;

import modeles.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Name : IItem
 * Interface qui permet a tous mes objet de pêrsister les donnée dans la base de donnée
 *
 * @author Francis Lafontaine
 * @version V1
 * @since 01/09/2022
 */
public interface IUserDao {
    EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("hibernate");
    /**
     * Permet d'insérer un objet dans la base de donnée
     * @param object a insérer
     * @return true si ok
     */
    default Boolean insert(Object object) {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(object);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return false;
        }
    }


    /**
     * Permet de supprimer un objet selon son id
     *
     * @param id de l'objet
     * @return message de suppression
     */
    default Object delete(long id) {
        return null;
    }

    /**
     * Recher un user par username
     *
     * @param username du user
     * @return un objet qui serai implémenter dans la classe concrète
     */
    default Object find(String username) {
        return null;
    }

    User getUser(long idUser);


    List<User> getAllUsers();

    boolean updateUser(long id, String username);

    String deleteUser(long idUser);

    boolean doExist(String username);


}
