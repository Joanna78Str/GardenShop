package pl.asia.view;

import pl.asia.api.GardenShopApi;
import pl.asia.infrastructure.entity.Client;

import java.time.LocalDate;
import java.util.List;

public class ApplicationConsole implements ApplicationView {

    GardenShopApi gardenShopApi = new GardenShopApi();

    @Override
    public void runApplication() {
        try {
            showMenu();
        } catch (Exception e) {
            e.printStackTrace();
            runApplication();
        }
    }

    private void showMenu() {
        boolean runApplication = true;
        while (runApplication) {
            System.out.println("Wybierz polecenie:\n" +
                    "[0] - wyjdź z programu\n" +
                    "[1] - utwórz konto użytkownika\n" +
                    "[2] - pobierz listę użytkowników\n" +
                    "[3] - pobierz klineta po Id\n" +
                    "[4] - usuń użytkownika\n" +
                    "[5] - edytuj dane użytkownika\n"+
                    "[6] - wprowadź roślinę\n" +
                    "[7] - pobierz listę roślin\n" +
                    "[8] - pobierz roślinę po Id\n"+
                    "[9] - usuń roślinę\n"+
                    "[10] - edytuj dane rośliny\n" +
                    "[11] - złóż zamówienie\n"+
                    "[12] - pobierz listę zamówień\n"+
                    "[13] - pobierz zamówienie\n" +
                    "[14] - usuń zamówienie\n"+
                    "[15] - edytuj zamówienie\n" );


            int choice = ScannerService.readInt();

            switch (choice) {
                case 1:
                    createUser();
                    break;
                case 2:
                    getClients();
                    break;
                case 3:
                    getClient();
                    break;
                case 4:
                    removeClient();
                    break;
                case 5:
                    updateClient();
                    break;
                case 6:
                    createItem();
                    break;
                case 7:
                    getPlants();
                    break;
                case 8:
                    getPlant();
                    break;
                case 9:
                    removePlant();
                    break;
                case 10:
                    updatePlant();
                    break;
                case 11:
                    createOrder();
                    break;
                case 12:
                    getOrders();
                    break;
                case 13:
                    getOrder();
                    break;
                case 14:
                    removeOrder();
                    break;
                case 15:
                    updateOrder();
                    break;
                case 0:
                default:
                    runApplication = false;
                    break;
            }
        }
    }

    private void createUser() {
        System.out.println("podaj imię użytkownika:");
        String firstName = ScannerService.readString();
        System.out.println("podaj nazwisko użytkownika:");
        String lastName = ScannerService.readString();
        System.out.println("podaj datę urodzenia użytkownika:");
        LocalDate birthdate = ScannerService.readDate();
        System.out.println("podaj email:");
        String email = ScannerService.readString();
        System.out.println("podaj numer telefonu:");
        Long phoneNumber = ScannerService.readLong();
        System.out.println("podaj adres:");
        String address = ScannerService.readString();
        System.out.println("podaj hasło:");
        String password = ScannerService.readString();

        gardenShopApi.saveClient(firstName,lastName,birthdate,email,phoneNumber,address,password);
    }

    private void getClients(){
        System.out.println(gardenShopApi.getClients());
    }
    private void getClient(){
        System.out.println("Podaj Id klienta:");
        Long id = ScannerService.readLong();
        System.out.println(gardenShopApi.getClient(id));
    }
    private void removeClient(){
        System.out.println("Podaj Id klienta:");
        Long id = ScannerService.readLong();
        gardenShopApi.removeClient(id);
        System.out.println("Usunięto klienta o id: " + id);
    }

    private void updateClient(){
        System.out.println("Podaj Id klienta:");
        Long id = ScannerService.readLong();
        System.out.println("podaj email:");
        String email = ScannerService.readString();
        System.out.println("podaj numer telefonu:");
        Long phoneNumber = ScannerService.readLong();
        System.out.println("podaj adres:");
        String address = ScannerService.readString();
        System.out.println("podaj hasło:");
        String password = ScannerService.readString();

        gardenShopApi.updateClient(email,phoneNumber,address,password,id);
    }
    private void createItem(){
        System.out.println("podaj nazwę rośliny:");
        String name = ScannerService.readString();
        System.out.println("podaj typ rośliny:");
        String type = ScannerService.readString();
        System.out.println("podaj producenta:");
        String producer = ScannerService.readString();
        System.out.println("podaj cenę:");
        Double price = ScannerService.readDouble();
        System.out.println("opisz roślinę:");
        String specification = ScannerService.readString();

        gardenShopApi.savePlant(name,type,producer,price,specification);
    }
    private void getPlants(){System.out.println(gardenShopApi.getPlants());}

    private void getPlant(){
        System.out.println("Podaj ID rośliny:");
        Long id = ScannerService.readLong();
        System.out.println(gardenShopApi.getPlant(id));
    }

    private void removePlant(){
        System.out.println("Podaj ID rośliny:");
        Long id = ScannerService.readLong();
        gardenShopApi.removePlant(id);
        System.out.println("Usunięto roślinę o ID: " + id);
    }

    private void updatePlant(){
        System.out.println("Podaj ID:");
        Long id = ScannerService.readLong();
        System.out.println("Podaj producenta:");
        String producer = ScannerService.readString();
        System.out.println("Podaj cenę:");
        double price = ScannerService.readDouble();

        gardenShopApi.updatePlant(producer,price,id);
    }

    private void createOrder(){
        System.out.println("podaj towar");
        String productName = ScannerService.readString();
        System.out.println("podaj ilość");
        int quantity = ScannerService.readInt();
        System.out.println("podaj cenę");
        double price = ScannerService.readDouble();

        gardenShopApi.saveOrder(productName,quantity,price);
        }
    private void getOrders(){System.out.println(gardenShopApi.getOrders());}

    private void getOrder(){
        System.out.println("Podaj ID zamówienia:");
        Long id = ScannerService.readLong();
        System.out.println(gardenShopApi.getOrder(id));
    }

    private void removeOrder(){
        System.out.println("Podaj ID zamówienia:");
        Long id = ScannerService.readLong();
        gardenShopApi.removeOrder(id);
        System.out.println("Usunięto zamówienie o ID: " + id);
    }

    private void updateOrder(){
        System.out.println("Podaj ID zamówienia:");
        Long id = ScannerService.readLong();
        System.out.println("Podaj ilość:");
        String quantity = ScannerService.readString();
        System.out.println("Podaj cenę:");
        double price = ScannerService.readDouble();

        gardenShopApi.updatePlant(quantity,price,id);


    }

}
