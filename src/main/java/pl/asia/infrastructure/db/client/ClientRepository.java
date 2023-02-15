package pl.asia.infrastructure.db.client;

import pl.asia.infrastructure.entity.Client;

public interface ClientRepository {
    Client saveClient(Client client);
}
