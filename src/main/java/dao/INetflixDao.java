package dao;

import modeles.Netflix;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public interface INetflixDao {
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
     * Permet d'aller cherche tout la liste des shows
     *
     * @return une liste de show complête
     */
    List<Netflix> getAllShows();

    /**
     * Permet d'aller chercher un show
     *
     * @return un show
     */
    Netflix getShow(int id);


    boolean updateNetflix(int id,String title,String type,String director,String cast,String country,
                          String dateAdded,int releaseYear,String rating,String duration,String listedIn,
                          String description);
}
