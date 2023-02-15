package pl.asia.infrastructure.db.client;

import pl.asia.infrastructure.entity.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientRepositoryInMemory implements ClientRepository {
    private final List<Client>clients=new ArrayList<>();
    private long id = 1;

    @Override
    public Client saveClient(Client client) {
        clients.add(new Client(id++,client.getFirstName(),client.getLastName(),client.getBirthday(),client.getEmail(),
                client.getPhoneNumber(),client.getAddress(),client.getPassword()));
        return client;
    }

    @Override
    public List<Client> getClients() {
        return clients;
    }
}
