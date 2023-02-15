package pl.asia.infrastructure.db.client;

import pl.asia.infrastructure.entity.Client;

import java.util.List;

public interface ClientRepository {
    Client saveClient(Client client);

    List<Client> getClients();
}
