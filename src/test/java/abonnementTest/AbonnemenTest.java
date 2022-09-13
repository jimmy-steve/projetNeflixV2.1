package abonnementTest;

import dao.AbonnementDao;
import dao.IAbonnementDao;
import dao.IUserDao;
import modeles.Abonnement;
import org.junit.jupiter.api.Test;

public class AbonnemenTest {
    @Test
    public void testInsert() {
        Abonnement abonnement = new Abonnement("1:","Annuelle",20.99,1);
        IAbonnementDao abonnementDao = new AbonnementDao();
        abonnementDao.insert(abonnement);
    }
}
