package dao;

import modeles.Client;

import java.util.List;

public interface IclientDao {

    static Client deleteClient(long id) {
        return null;
    }

    List<Client> getAllClients();

    Object getClient(long numeroClient);

    void insert(Client client);
}
