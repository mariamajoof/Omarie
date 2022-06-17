package DummyCode;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

@Entity
@Table(name = "rental")

public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    int rental_id;
    DateTimeFormat rental_date;
    int inventory_id;
    int customer_id;
    DateTimeFormat return_date;
    int staff_id;
    DateTimeFormat last_update;

    public Rental(int rental_id, DateTimeFormat rental_date, int inventory_id,
                  int customer_id, DateTimeFormat return_date, int staff_id,DateTimeFormat last_update){
        this.customer_id = customer_id;
        this.inventory_id = inventory_id;
        this.last_update = last_update;
        this.rental_date = rental_date;
        this.rental_id = rental_id;
        this.return_date = return_date;
        this.staff_id = staff_id;
    }

    public Rental(){}

    public int getRental_id() {
        return rental_id;
    }

    public void setRental_id(int rental_id) {
        this.rental_id = rental_id;
    }

    public DateTimeFormat getRental_date() {
        return rental_date;
    }

    public void setRental_date(DateTimeFormat rental_date) {
        this.rental_date = rental_date;
    }

    public int getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(int inventory_id) {
        this.inventory_id = inventory_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public DateTimeFormat getReturn_date() {
        return return_date;
    }

    public void setReturn_date(DateTimeFormat return_date) {
        this.return_date = return_date;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public DateTimeFormat getLast_update() {
        return last_update;
    }

    public void setLast_update(DateTimeFormat last_update) {
        this.last_update = last_update;
    }
}
