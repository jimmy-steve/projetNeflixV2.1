package dao;

import modeles.Netflix;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Name INetflixDao
 * Interface permettant  de faire des opération CRUD sur la classe netflix
 *
 * @author Francis lafontaine
 * @version V1
 * @since 18 septembre/2022
 */
public interface INetflixDao {
    EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("hibernate");

    /**
     * Permet d'insérer un objet dans la base de donnée
     *
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

    /**
     * Name : updateNetflix
     * Permet de faire un update d'un film
     *
     * @param id          du film
     * @param title       du film
     * @param type        un type de film ou Show
     * @param director    le directeur du film
     * @param cast        le casting du film
     * @param country     le pays d'origine du film
     * @param dateAdded   la date ajouter du film
     * @param releaseYear l'année qu'a sortie le film
     * @param rating      le reting du film
     * @param duration    la duration du film
     * @param listedIn    les catégorie dans lequelle peut etre lister
     * @param description la description du film
     * @return tru si l'update a été effectuer
     */
    boolean updateNetflix(int id, String title, String type, String director, String cast, String country,
                          String dateAdded, int releaseYear, String rating, String duration, String listedIn,
                          String description);

    /**
     * Name : findNetflixShow
     * Permet d'aller chercher une liste de films selon 2 critéres
     *
     * @param currentPage  la page courante
     * @param numOfRecords le nombre de ligne a afficher par page
     * @return
     */
    List<Netflix> findNetflixShow(int currentPage, int numOfRecords);

    /**
     * Name : getNumberOfRow
     * Permet d'aller chercher le nombre total d'enregistrement dans la bd
     *
     * @return un int qui est le nombre total de ligne
     */
    int getNumberOfRows();

}
