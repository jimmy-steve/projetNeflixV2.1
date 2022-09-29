package dao;

import modeles.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.sql.PreparedStatement;
import java.util.List;

/**
 * Name : UserDao
 * Classe qui implémente la classe IItem
 * et permet de persister tout les donnée et de faire les requête
 * pour le user
 *
 * @author Francis Lafontaine
 * @version V2
 * @since 01/09/2022
 */
public class UserDao implements IUserDao {
    /**
     * Name : getAllUsers
     * Méthode permmetant d'aller chercher tout la liste des users
     * pour pouvoir les modifié par apres
     *
     * @return une liste de tous les users
     */
    @Override
    public List<User> getAllUsers() {
        List listeUsers = null;

        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNativeQuery("SELECT * FROM User;", User.class);

            listeUsers = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return listeUsers;
        } finally {
            entityManager.close();
        }
        return listeUsers;
    }

    /**
     * Name : GetUser
     * Permetant d'aller chercher un user pour modifié ces informations
     *
     * @param idUser pren un int en paramete qui est le id user
     * @return le user directement
     */
    @Override
    public User getUser(long idUser) {
        User user = null;
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            user = entityManager.find(User.class, idUser);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return user;
        } finally {
            entityManager.close();
        }
    }

    /**
     *  Name : updateUser
     *  Permet de faire un update du user
     * @param username qui sera modificé
     * @return un user modifé
     */
    @Override
    public boolean updateUser(long id, String username) {

        EntityManager entityManager = null;

        /*
         * faire un try catch pour gerer les probleme lors de la transaction
         */

        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            /*
             * recherche une personne selon son id
             */

            User user = entityManager.find(User.class, id);
            user.setUsername(username);

            entityManager.merge(user);
            entityManager.persist(user);
            entityManager.getTransaction().commit();//dans L'etat de persistent
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();//----------------reviens en arrière
            return false;
        } finally {
            entityManager.close();//dans l'etat detached
        }
    }

    /**
     * Name : deleteUser
     * <p>
     * Permet de supprimer un user dans la base de donnée
     *
     * @param idUser du user que l'on veut supprimer
     * @return un message de confirmation dans la console
     */
    @Override
    public String deleteUser(long idUser) {
        User user = null;
        EntityManager entityManager = null;
        /*
         * faire un try catch pour gerer les probleme lors de la transaction
         */
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            /*
             * recherche une personne selon son id
             */

            user = entityManager.find(User.class, idUser);

            /*
             * on supprime  la personne
             */

            user = entityManager.merge(user);
            entityManager.remove(user);
            entityManager.getTransaction().commit();//dans L'etat de persistent

            return "Suppression Effectuée de l'id :" + idUser;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();//----------------reviens en arrière
            return "Erreur de transaction " + idUser;
        } finally {
            entityManager.close();//dans l'etat detached
        }

    }

    /**
     * Name : fin
     * permet de recherche un user par son username
     *
     * @param username du user
     * @return le user trouvé ou null
     */
    @Override
    public Object find(String username) throws NullPointerException{
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            User user = entityManager.createQuery("SELECT u from User u WHERE u.username = :username", User.class).
                    setParameter("username", username).getSingleResult();
            entityManager.close();
            return user;
        } catch (PersistenceException e) {
            e.printStackTrace();
            assert entityManager != null;
            entityManager.getTransaction().rollback();
            return null;
        }
    }

    /**
     * Name : doExist
     * Permet d'aller vérifier dans la base de donnée si le username existe
     *
     * @param username le username du user
     * @return true si il existe
     */
    @Override
    public boolean doExist(String username) {
        EntityManager entityManager = null;
        try {

            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            User user = entityManager.createQuery("SELECT u from User u WHERE u.username = :username", User.class).
                    setParameter("username", username).getSingleResult();
            entityManager.close();
            return true;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        } catch (NoResultException ignored) {
            return false;

        } catch (PersistenceException e) {
            e.printStackTrace();
            assert entityManager != null;
            entityManager.getTransaction().rollback();
            return false;
        }
    }
}
