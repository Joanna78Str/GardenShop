package pl.asia.api;

import pl.asia.domain.service.ClientService;
import pl.asia.infrastructure.entity.Client;

import java.time.LocalDate;
import java.util.List;

public class GardenShopApi {
    private final ClientService clientService = new ClientService();

    public Client saveClient(String firstName, String lastName, LocalDate birthday, String email, Long phoneNumber,
                             String address, String password){
        return clientService.saveClient(firstName,lastName,birthday,email,phoneNumber,address,password);
    }

    public List<Client> getClients(){
        return clientService.getClients();
    }
}
