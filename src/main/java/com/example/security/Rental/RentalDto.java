package com.example.security.Rental;

import com.example.security.client.Client;
import com.example.security.item.Item;

import java.sql.Date;

public class RentalDto {

    private Long id;
    private Date start;
    private Date end;
    private RentalStatus status;
    private Long clientId;
    public String firstName;
    public String lastName;
    private Long itemId;
    private String itemIndeks;
    private String itemName;
    private String itemHourPrice;
    public Item item;
    public Client client;


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

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getItemIndeks() {
        return itemIndeks;
    }

    public void setItemIndeks(String itemIndeks) {
        this.itemIndeks = itemIndeks;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemHourPrice() {
        return itemHourPrice;
    }

    public void setItemHourPrice(String itemHourPrice) {
        this.itemHourPrice = itemHourPrice;
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

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public RentalStatus getStatus() {
        return status;
    }

    public void setStatus(RentalStatus status) {
        this.status = status;
    }
}
