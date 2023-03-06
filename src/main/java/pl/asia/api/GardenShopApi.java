package pl.asia.api;

import pl.asia.domain.service.ClientService;
import pl.asia.domain.service.OrderService;
import pl.asia.domain.service.PlantService;
import pl.asia.infrastructure.db.client.ClientRepositoryInMemory;
import pl.asia.infrastructure.db.order.OrderRepositoryInMemory;
import pl.asia.infrastructure.db.plant.PlantRepositoryInMemory;
import pl.asia.infrastructure.entity.Client;
import pl.asia.infrastructure.entity.Order;
import pl.asia.infrastructure.entity.Plant;

import java.time.LocalDate;
import java.util.List;

public class GardenShopApi {
    private final ClientService clientService = new ClientService(new ClientRepositoryInMemory());
    private final PlantService plantService = new PlantService(new PlantRepositoryInMemory());
    private final OrderService orderService = new OrderService(new OrderRepositoryInMemory());


    public Client saveClient(String firstName, String lastName, LocalDate birthday, String email, Long phoneNumber,
                             String address, String password) {
        return clientService.saveClient(firstName, lastName, birthday, email, phoneNumber, address, password);
    }

    public List<Client> getClients() {
        return clientService.getClients();
    }

    public Client getClient(Long id) {
        return clientService.getClient(id);
    }

    public void removeClient(Long id) {
        clientService.removeClient(id);
    }

    public void updateClient(String email, Long phoneNumber, String address, String password, Long id) {
        clientService.updateClient(email, phoneNumber, address, password, id);
    }

    public Plant savePlant(String name, String type, String producer, double price, String specification){
        return plantService.savePlant(name, type, producer, price, specification);
        }
    public List<Plant> getPlants(){ return plantService.getPlants();}

    public Plant getPlant(Long id) {return plantService.getPlant(id);}

    public void removePlant(Long id) {plantService.removePlant(id);}

    public void updatePlant(String producer, double price, Long id){
        plantService.updatePlant(producer, price, id);
    }

    public Order saveOrder(String productName, int quantity, double price) {
        return orderService.saveOrder(productName,quantity,price);
    }
    public List<Order>getOrders(){return orderService.getOrders();}

    public Order getOrder(Long id) {return orderService.getOrder(id);}

    public void removeOrder(Long id) {orderService.removeOrder(id);}

    public void updateOrder(int quantity, double price, Long id) {
        orderService.updateOrder(quantity,price,id);
    }
}
