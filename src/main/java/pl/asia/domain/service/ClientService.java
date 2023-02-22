package pl.asia.domain.service;

import pl.asia.infrastructure.db.client.ClientRepository;
import pl.asia.infrastructure.db.client.ClientRepositoryInMemory;
import pl.asia.infrastructure.entity.Client;

import java.time.LocalDate;
import java.util.List;

public class ClientService {
    private final ClientRepository clientRepository = new ClientRepositoryInMemory();

    public Client saveClient(String firstName, String lastName, LocalDate birthday, String email, Long phoneNumber,
                             String address, String password){
        return clientRepository.saveClient(new Client(firstName,lastName,birthday,email,phoneNumber,address,password));
    }

    public List<Client> getClients(){
        return clientRepository.getClients();
    }
    public Client getClient(Long id){
        return clientRepository.getClient(id);
    }

    public void removeClient(Long id) {
        clientRepository.removeClient(id);
    }

    public void updateClient(String email, Long phoneNumber, String address, String password,Long id){
        Client clientFromDB = clientRepository.getClient(id);
        Client clientToUpdate = new Client(
                clientFromDB.getId(),
                clientFromDB.getFirstName(),
                clientFromDB.getLastName(),
                clientFromDB.getBirthday(),
                email, phoneNumber, address, password
        );
        clientRepository.updateClient(clientToUpdate);
    }
}
