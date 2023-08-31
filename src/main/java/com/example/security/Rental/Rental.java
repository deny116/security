package com.example.security.Rental;

import com.example.security.client.Client;
import com.example.security.item.Item;
import org.springframework.stereotype.Controller;

import javax.persistence.*;
import java.sql.Date;
import java.text.SimpleDateFormat;

@Entity
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "poczatek")
    private Date start;
    @Column(name = "koniec")
    private Date end;
    @ManyToOne
    @JoinColumn(name="items_id")
    public Item item;
    @ManyToOne
    @JoinColumn(name = "client_id")
    public Client client;
    @Enumerated(EnumType.STRING)
    private RentalStatus status;
    public Rental() {
    }

    public Rental(Long id, Date start, Date end, Item item, Client client) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.item = item;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public RentalStatus getStatus() {
        return status;
    }

    public void setStatus(RentalStatus status) {
        this.status = status;
    }


}