package com.tsi.mariama.joof.program;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
@Table(name = "customer")

// Creating the method
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //Attributes
    int customer_id;
    int address_id;
    int active;
    int store_id;
    String first_name;
    String last_name;
    String email;
    DateTimeFormat create_date;
    DateTimeFormat last_update;

    // constructor
    public Customer(int customer_id, int address_id, int active, int store_id, String first_name, String last_name, String email, DateTimeFormat create_date, DateTimeFormat last_update ){
        this.first_name = first_name;
        this.last_name = last_name;
        this.active = active;
        this.address_id = address_id;
        this.create_date = create_date;
        this.customer_id = customer_id;
        this.email = email;
        this.last_update = last_update;
        this.store_id =  store_id;
    }

    public Customer(){}

    //Getters
    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DateTimeFormat getCreate_date() {
        return create_date;
    }

    public void setCreate_date(DateTimeFormat create_date) {
        this.create_date = create_date;
    }

    public DateTimeFormat getLast_update() {
        return last_update;
    }

    public void setLast_update(DateTimeFormat last_update) {
        this.last_update = last_update;
    }
}
