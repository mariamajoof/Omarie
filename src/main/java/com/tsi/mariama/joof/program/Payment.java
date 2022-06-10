package com.tsi.mariama.joof.program;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Currency;

@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int payment_id;
    int customer_id;
    int staff_id;
    int rental_id;
    Currency amount;
    DateTimeFormat payment_date;
    DateTimeFormat last_update;

    public Payment(int payment_id, int customer_id, int staff_id, int rental_id,
                   Currency amount, DateTimeFormat payment_date, DateTimeFormat last_update){
        this.payment_id = payment_id;
        this.customer_id = customer_id;
        this.staff_id = staff_id;
        this.rental_id = rental_id;
        this.amount = amount;
        this.payment_date = payment_date;
        this.last_update = last_update;

    }
    public Payment(){}


    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public int getRental_id() {
        return rental_id;
    }

    public void setRental_id(int rental_id) {
        this.rental_id = rental_id;
    }

    public Currency getAmount() {
        return amount;
    }

    public void setAmount(Currency amount) {
        this.amount = amount;
    }

    public DateTimeFormat getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(DateTimeFormat payment_date) {
        this.payment_date = payment_date;
    }

    public DateTimeFormat getLast_update() {
        return last_update;
    }

    public void setLast_update(DateTimeFormat last_update) {
        this.last_update = last_update;
    }
}
