package DummyCode;

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
    Currency amount;


    public Payment(int payment_id, int customer_id, Currency amount){
        this.payment_id = payment_id;
        this.customer_id = customer_id;
        this.amount = amount;


    }
    public Payment(){}


  //Getters and setters


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

    public Currency getAmount() {
        return amount;
    }

    public void setAmount(Currency amount) {
        this.amount = amount;
    }
}
