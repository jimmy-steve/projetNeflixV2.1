package dao;

import modeles.Client;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Names : IClientDao
 * Interface qui seras implémenter par la classe concrètre ClientDao
 * @author Francis Lafontaine
 * @since 12/sept/2022
 * @version V2
 */
public interface IclientDao {

    EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("hibernate");

    static Client deleteClient(long id) {
        return null;
    }

    /**
     * Name : getAllClient
     * Permet d'aller crcher tout les client dans la base de donnée
     * @return une list de client
     */
    List<Client> getAllClients();

    /**
     * Name : getClientByUser
     * permet d,aller chercher un client avec le idUser
     *
     * @param idUser un long qui est le id_user du user rechercher
     * @return le client recherché
     */
    Client getClientByIdUser(long idUser);

    /**
     * Name : insert
     * Permet d'insérer un enregistrement dans la bd
     * @param client le client qui sera insérer
     * @return le client qui a été insérer
     */
    Client insert(Client client);

    /**
     * Name : GetClient
     * Permet d'aller les information d'un client
     * @param numeroClient qui est le id du client
     * @return le client qui a été trouver
     */
    Client getClient(long numeroClient);

    /**
     * Name : updateClient
     * permet de faire un update complet d'un client
     * @param id son id
     * @param nom son nom
     * @param prenom son prenom
     * @param adresse son adresse
     * @param email son email
     * @param telephone son telpehone
     * @param idUser sont idUser
     * @return true si L'insertion a été effectuer
     */
    boolean updateClient(long id, String nom, String prenom, String adresse, String email,
                                String telephone, long idUser);

    boolean updateClient(long id, String nom);
}
