package dao;

import modeles.Abonnement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class AbonnementDao implements IAbonnementDao {
    static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("hibernate");

    /**
     * Name: getAllAbonnements
     * Permet d'aller chercher la liste d'abonnements de la base de données
     *
     * @return list d'abonnements
     */
    public List<Abonnement> getAllAbonnements() {
        List listAbonnements = null;

        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNativeQuery("SELECT u.username, a.id_user ,a.id_abonnement, " +
                    "a.type_abonnement, a.prix FROM user u JOIN abonnement a ON u.id_user = a.id_user; ", Abonnement.class);
            listAbonnements = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return listAbonnements;
        } finally {
            entityManager.close();
        }
        return listAbonnements;
    }



    /**
     * Permet de calculer le prix de l'abonnement choisi
     *
     * @param typeAbonnement
     * @return le prix de l'abonnement
     */
    public double calculerPrix(String typeAbonnement){
        double prixCalc = 0;
        switch (typeAbonnement) {
            case "3mois":
                prixCalc = 25.99;
                break;
            case "6mois":
                prixCalc = 44.99;
                break;
            case "annuel":
                prixCalc = 79.99;
                break;
            case "2ans":
                prixCalc = 129.99;
                break;
        }
        return prixCalc;
    }
}
