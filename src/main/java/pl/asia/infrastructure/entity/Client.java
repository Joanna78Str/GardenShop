package pl.asia.infrastructure.entity;

import java.time.LocalDate;

public class Client {
    private Long id;
    private final String firstName;
    private final String lastName;
    private final LocalDate birthday;
    private final String email;
    private final Long phoneNumber;
    private final String address;
    private final String password;

    public Client(Long id, String firstName, String lastName, LocalDate birthday, String email, Long phoneNumber,
                  String address, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.password = password;
    }

    public Client(String firstName, String lastName, LocalDate birthday, String email, Long phoneNumber, String address, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }
}