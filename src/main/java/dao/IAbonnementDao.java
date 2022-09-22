package dao;

import modeles.Abonnement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public interface IAbonnementDao {
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

    List<Abonnement> getAllAbonnements();

    double calculerPrix(String typeAbonnement);
}
