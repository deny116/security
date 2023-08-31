package com.example.security.client;
import com.example.security.Rental.Rental;
import com.example.security.Rental.RentalDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Client {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        public String firstName;

        public String lastName;
        private String pesel;
        private String email;
        @OneToMany(mappedBy = "client", cascade = { CascadeType.REMOVE, CascadeType.PERSIST })
        private List<Rental> rentals = new ArrayList<>();

        public Client() {
        }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id) &&
                Objects.equals(firstName, client.firstName) &&
                Objects.equals(lastName, client.lastName) &&
                Objects.equals(pesel, client.pesel) &&
                Objects.equals(email, client.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, pesel, email);
    }

}
