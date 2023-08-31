package com.example.security.item;

import com.example.security.Rental.Rental;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String indeks;
    private String name;
    private String hourPrice;

    @OneToMany(mappedBy = "item", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<Rental> rentals = new ArrayList<>();

    public Item() {
    }

    public Item(String indeks, String name, String hourPrice) {
        this.indeks = indeks;
        this.name = name;
        this.hourPrice = hourPrice;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", indeks=" + indeks +
                ", name='" + name + '\'' +
                ", hourPrice=" + hourPrice +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIndeks() {
        return indeks;
    }

    public void setIndeks(String indeks) {
        this.indeks = indeks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHourPrice() {
        return hourPrice;
    }

    public void setHourPrice(String hourPrice) {
        this.hourPrice = hourPrice;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

}