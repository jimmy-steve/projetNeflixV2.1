package dao;

import modeles.Favoris;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public interface IfavorisDao {
    EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("hibernate");


    Boolean insertFavoris(Favoris favoris);

     List<Object> getAllFavoris();
}
