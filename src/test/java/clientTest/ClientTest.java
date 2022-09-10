package clientTest;

import dao.AbonnementDao;
import dao.ClientDao;
import dao.IItem;
import dao.IclientDao;
import dao.UserDao;
import modeles.Abonnement;
import modeles.Client;
import modeles.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static utilitaire.GenerateurNombreSequentiel.*;
import static utilitaire.GenerateurNombreSequentiel.genererNombre;


public class ClientTest {
    @Test
    public void testInsert() {
        for (int i = 0; i < 2; i++) {
            Client client = new Client("testNom", "testPrenom", "testAdresse",
                    "testo@gmail.com", "(450)555-5555",
                    genererNombre());
            IclientDao clientDao = (IclientDao) new ClientDao();
            clientDao.insert(client);
        }
    }

    @Test
    public void testGetAllClients() {
        ClientDao clientDao = new ClientDao();
        List<Client> listClients = clientDao.getAllClients();
        for (Client tmp : listClients
        ) {
            System.out.println(tmp);
        }
    }

    @Test
    public void testCreationNewClientAbonnement() {
        /*
         * je décide de créer plusieurs client avec les meme information nais avec id difféend
         */
        for (int i = 0; i < 5; i++) {
            /*
             * je créer un client typique
             */
            Client client = new Client("testNom", "testPrenom", "testAdresse",
                    "testo@gmail.com", "(450)555-5555", genererNombre());

            /*
             * je créer un user typique
             */
            User user = new User("test", "1234", "null2");
            /*
             * j'enregistre le user dans la base de donnée
             */
            IItem userDao = new UserDao();
            userDao.insert(user);
            /*
             * J'enregistre le client dans la base de donnée
             */
            client.setIdUser(user.getIdUser());
            IItem clientDao = new ClientDao();
            clientDao.insert(client);

            /*
             * je créer un abonnement pour le user
             */
            Abonnement abonnement = new Abonnement(client.getIdAbonnement(), "Annuel", 25.77, user.getIdUser());

            /*
             * J"enregistre l'abonnement fans la base donnée
             */

            AbonnementDao abonnementDao = new AbonnementDao();
            abonnementDao.insert(abonnement);
        }

    }


    @Test
    public void testGenererTableauSequentiel() {
        List<String> liste = new ArrayList();

        for (int i = 0; i < 25; i++) {
            String nbr = genererNombre();
            liste.add(nbr);
        }

        for (String tmp : liste
        ) {
            System.out.println(tmp);
        }
    }

    @Test
    public void testGetClient() {
        ClientDao clientDao = new ClientDao();

        System.out.println(ClientDao.getClient(1L));

    }

    @Test
    public void testDeleteClient() {
        ClientDao clientDao = new ClientDao();
        Client client = ClientDao.deleteClient(14L);

        UserDao userDao = new UserDao();
        System.out.println(userDao.deleteUser(client.getIdUser()));

    }




}



