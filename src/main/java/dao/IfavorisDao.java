package dao;

import modeles.Favoris;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public interface IfavorisDao {
    EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("hibernate");

    /**
     * Name : Insert Favoris
     * Permet d'insérer un favoris dans la base de donnée
     *
     * @param favoris un favoris
     * @return true si l'insertion est ok
     */
    Boolean insertFavoris(Favoris favoris);

    /**
     * Name : getAllFavoris
     * Permet d'aller chercher une liste de toute les favoris
     *
     * @return une liste de favoris
     */
    List<Favoris> getAllFavoris();

    /**
     * Name : SaveListFavoris
     *
     * @param list de favoris
     * @return true si c'est ok
     */
    boolean SaveListFavoris(List<Favoris> list);

    /**
     * Name : supprimerFavoris
     * Permet d'aller supprimmer un favoris dans la base de donnée
     *
     * @param id du favoris
     * @return true si tout est ok
     */
    boolean supprimerFavoris(int id);

    /**
     * Name : getFavorisById
     * Permet d'aller chercher un afvoris dans la base de donnée avec son id
     *
     * @param id du favoris
     * @return une liste de favoris
     */
    List<Favoris> getFavorisById(long id);

}
