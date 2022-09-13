package favorisTest;

import dao.*;
import modeles.Favoris;
import org.junit.jupiter.api.Test;
import utilitaire.GenerateurNombreSequentiel;

import java.util.ArrayList;
import java.util.List;

public class FavorisTest {
    @Test
    public void testInsert() {
        Favoris favoris = new Favoris("202299:18:11:361", 1L,3);

        IfavorisDao ifavorisDao = new FavorisDao();

        ifavorisDao.insertFavoris(favoris);
    }

    @Test
    public void testInsertListFavoris() {
        List<Favoris> listFavoris = new ArrayList<>();
        GenerateurNombreSequentiel.genererNombre();
        Favoris favoris1 = new Favoris("202299:18:11:361", 1L,77);
        Favoris favoris2 = new Favoris("202299:18:11:361", 1L,88);
        Favoris favoris3 = new Favoris("202299:18:11:361", 1L,99);
        Favoris favoris4 = new Favoris("202299:18:11:361", 1L,88);

        listFavoris.add(favoris1);
        listFavoris.add(favoris2);
        listFavoris.add(favoris3);
        listFavoris.add(favoris4);

        IfavorisDao ifavorisDao = new FavorisDao();
        boolean resultat = ifavorisDao.SaveListFavoris(listFavoris);

        if (resultat){
            System.out.println("La liste a été effectuer avec succès");
        }
    }

    @Test
    public void testDeleteFavoris() {
        int id = 3;
        IfavorisDao ifavorisDao = new FavorisDao();
        ifavorisDao.supprimerFavoris(id);
    }

    @Test
    public void testGetAllFavoris() {
        IfavorisDao ifavorisDao = new FavorisDao();
        List<Favoris> list = ifavorisDao.getAllFavoris();

        for (Favoris tmp : list
             ) {
            System.out.println(tmp);
        }

    }

    @Test
    public void testGetFavorisByIdUser() {
        long id = 1;
        IfavorisDao ifavorisDao = new FavorisDao();
        List<Favoris> listPerso = ifavorisDao.getFavorisById(id);

        for (Favoris tmp : listPerso
        ) {
            System.out.println(tmp);
        }

    }
}
