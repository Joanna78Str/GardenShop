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

    @Override
    public Client getClient(Long id) {
        return clients.stream()
                .filter(client -> client.getId().equals(id))
                .findAny()
                .orElseThrow(() -> {throw new RuntimeException("Klient o podanym id nie istnieje");});
    }

    @Override
    public void removeClient(Long id) {
        Client client = getClient(id);
        clients.remove(client);
    }

    @Override
    public void updateClient(Client client) {
      removeClient(client.getId());
      clients.add(client);
    }
}
