package dao;

import modeles.Client;
import modeles.User;

import javax.persistence.*;
import java.util.List;

/**
 * Name : ClientDao
 * Cette classe qui implémente IItem
 * permet de persister les données pour le client
 *
 * @author Francis Lafontaine
 * @version V1
 * @since 01/09/2022
 */
public class ClientDao implements IItem {
    static EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("hibernate");

    /**
     * Name : deleteClient
     * Permet d'aller supprimer un client dans la base de donnée
     *
     * @param id du client a supprimer
     * @return un client pour permet la suppresion du users
     */
    public static Client deleteClient(long id) {
        Client client = null;
        EntityManager entityManager = null;
        /*
         * faire un try catch pour gerer les probleme lors de la transaction
         */
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            /*
             * recherche un client selon son id
             */

            client = entityManager.find(Client.class, id);

            /*
             * on supprime  la personne
             */

            client = entityManager.merge(client);
            entityManager.remove(client);
            entityManager.getTransaction().commit();//dans L'etat de persistent
            return client;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return client;
        } finally {
            entityManager.close();
        }

    }

    /**
     * Name : GetAllClients
     * permettant d'aller chercher une listes de client dans la base de donnée
     *
     * @return la liste de tout les clients
     */
    public List<Client> getAllClients() {
        List listeClients = null;

        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Query query = entityManager.createNativeQuery("SELECT * FROM client;", Client.class);
            listeClients = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return listeClients;
        } finally {
            entityManager.close();
        }
        return listeClients;
    }

    /**
     * Name : getClient
     * Méthode permettant d'aller cherche un client
     *
     * @param numeroClient qui est son id de client
     * @return un objet de type client
     */
    public static Object getClient(long numeroClient) {
        Object client = null;
        EntityManager entityManager = null;

        /*
         * faire un try catch pour gerer les probleme lors de la transaction
         */

        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            client = entityManager.find(Client.class, numeroClient);
            return client;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return client;
        } finally {
            entityManager.close();
        }
    }

    /**
     * Name : updateClient
     * Permet de faire un update complet d'un client
     *
     * @param id        son id de client
     * @param nom       de client
     * @param prenom    son prenom de cleint
     * @param adresse   son adresse
     * @param email     son email
     * @param telephone son telephone
     * @param idUser    son iderUser
     * @return true si ok
     */
    public boolean updateClient(long id, String nom, String prenom, String adresse, String email,
                                String telephone, long idUser) {
        EntityManager entityManager = null;

        /*
         * faire un try catch pour gerer les probleme lors de la transaction
         */

        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            /*
             * recherche une personne selon son id
             */

            Client client = entityManager.find(Client.class, id);
            client.setNom(nom);//--------------------------- dans l'etat detached
            client.setPrenom(prenom);
            client.setEmail(email);
            client.setAdresse(adresse);
            client.setTelephone(telephone);
            client.setIdUser(idUser);
            entityManager.merge(client);
            entityManager.persist(client);
            entityManager.getTransaction().commit();//dans L'etat de persistent
            System.out.println("Réussi");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();//----------------reviens en arrière
            return false;
        } finally {
            entityManager.close();//dans l'etat detached
        }
    }


    public Client getClientByIdUser(long idUser) {
        EntityManager entityManager = null;
        try {
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Client client = entityManager.createQuery("SELECT c from Client c WHERE c.idClient = :id_user", Client.class).
                    setParameter("id_user", idUser).getSingleResult();
            entityManager.close();
            return client;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        } catch (PersistenceException e) {
            e.printStackTrace();
            assert entityManager != null;
            entityManager.getTransaction().rollback();
            return null;
        }
    }
}
