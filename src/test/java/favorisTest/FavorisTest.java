package favorisTest;

import dao.ClientDao;
import dao.FavorisDao;
import dao.IItem;
import dao.IfavorisDao;
import modeles.Client;
import modeles.Favoris;
import org.junit.jupiter.api.Test;

import static utilitaire.GenerateurNombreSequentiel.genererNombre;

public class FavorisTest {
    @Test
    public void testInsert() {
        Favoris favoris = new Favoris("202299:18:11:361", 1L,3);

        IfavorisDao ifavorisDao = new FavorisDao();

        ifavorisDao.insertFavoris(favoris);


    }
}
