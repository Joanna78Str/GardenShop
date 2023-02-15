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
                    "[2] - pobierz listę użytkowników\n");


            int choice = ScannerService.readInt();

            switch (choice) {
                case 1:
                    createUser();
                    break;
                case 2:
                    getClients();
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

}
