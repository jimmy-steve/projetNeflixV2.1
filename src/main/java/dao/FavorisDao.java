package dao;

import modeles.Favoris;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class FavorisDao implements IfavorisDao{

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

    @Override
    public List<Object> getAllFavoris() {
        List<Object> listeFavoris = null;

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
}
