package dao;

import modeles.Favoris;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Name : FavorisDao
 * Classe concrète qui implémente l'interface IfavorisFao
 * Permet de faire des opération dans la base de donnée pour sauvegarder les favoris
 *
 * @author Francis lafontaine
 * @version V1
 * @since 19/septembre/2022
 */
public class FavorisDao implements IfavorisDao {
    EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("hibernate");

    /**
     * Name : insertFavoris
     * Permet d'insérer un favoris dans la base de donnée
     *
     * @param favoris un favoris
     * @return un boolean true si l'insertiona été effectuer
     */
    @Override
    public Boolean insertFavoris(Favoris favoris) {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(favoris);
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
     * Name : getAllFavoris
     * Permet d'aller chercher tout les favoris
     *
     * @return une liste de favoris
     */
    @Override
    public List<Favoris> getAllFavoris() {
        List<Favoris> listeFavoris = null;

        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNativeQuery("SELECT * FROM FAVORIS;", Favoris.class);
            listeFavoris = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return listeFavoris;
        } finally {
            entityManager.close();
        }
        return listeFavoris;
    }

    /**
     * Name : SaveListFavoris
     * Permet de saver une liste de favoris dans la bd
     *
     * @param list de favoris
     * @return true si tout les insertion ont été effectuer
     */
    @Override
    public boolean SaveListFavoris(List<Favoris> list) {
        EntityManager entityManager = null;
        for (Favoris tmp : list
        ) {
            try {
                entityManager = entityManagerFactory.createEntityManager();
                entityManager.getTransaction().begin();
                entityManager.persist(tmp);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                e.printStackTrace();
                entityManager.getTransaction().rollback();
                return false;
            } finally {
                entityManager.close();
            }
        }
        return true;
    }

    /**
     * Name : suppriemrFavoris
     * Permet de supprimer un favoris de la base de donnée
     *
     * @param id du favoris
     * @return true si l'a suppresion a été effectué
     */
    @Override
    public boolean supprimerFavoris(int id) {
        Favoris favoris = null;
        EntityManager entityManager = null;
        /*
         * faire un try catch pour gerer les probleme lors de la transaction
         */
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            favoris = entityManager.find(Favoris.class, id);
            entityManager.remove(favoris);
            entityManager.getTransaction().commit();//dans L'etat de persistent
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return false;
        } finally {
            entityManager.close();
        }
    }

    /**
     * name : getFavorisById
     * Permet d'aller chercher une liste de favoris favoris avec son id
     *
     * @param id du favoris
     * @return une liste de favoris
     */
    @Override
    public List<Favoris> getFavorisById(long id) {
        List<Favoris> listeFavorisPerso = null;

        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNativeQuery("select * from favoris where id_user = " + id, Favoris.class);
            listeFavorisPerso = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return listeFavorisPerso;
        } finally {
            entityManager.close();
        }
        return listeFavorisPerso;
    }

}
