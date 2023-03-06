package pl.asia.domain.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.asia.infrastructure.db.client.ClientRepositoryInMemory;
import pl.asia.infrastructure.entity.Client;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ClientServiceTest {
    private final ClientRepositoryInMemory clientRepositoryInMemory = new ClientRepositoryInMemory();
    private final ClientService clientService = new ClientService(clientRepositoryInMemory);
    private final String FIRSTNAME = "Jan";
    private final String LASTNAME = "Nowak";
    private final String EMAIL = "JanNowak@gmail.com";
    private final String ADDRESS = "Warszawa ul.Grzybowska 12/8";
    private final String PASSWORD = "Password";
    private final LocalDate BIRTHDAY = LocalDate.of(1972,9,14);
    private final Long PHONE_NUMBER = 788999000L;

    @Test
    public void createClientShouldReturnClientWhitValidData(){
        Client client = clientService.saveClient(FIRSTNAME,LASTNAME,BIRTHDAY,EMAIL,PHONE_NUMBER,ADDRESS,PASSWORD);
        Assertions.assertEquals(FIRSTNAME,client.getFirstName());
        Assertions.assertEquals(LASTNAME,client.getLastName());
        Assertions.assertEquals(BIRTHDAY,client.getBirthday());
        Assertions.assertEquals(EMAIL,client.getEmail());
        Assertions.assertEquals(PHONE_NUMBER,client.getPhoneNumber());
        Assertions.assertEquals(ADDRESS,client.getAddress());
        Assertions.assertEquals(PASSWORD,client.getPassword());

    }

}