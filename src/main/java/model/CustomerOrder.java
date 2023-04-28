package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.eclipse.persistence.annotations.UuidGenerator;

@Entity
@UuidGenerator(name = "CUSTOMERORDER_ID")
public class CustomerOrder {

    @Id
    @GeneratedValue (generator = "CUSTOMERORDER_ID")
    private String id;
    private String customer_id;
    private String payment_id;
    private String date;

    public CustomerOrder() {
    }

    public CustomerOrder(String customer_id, String payment_id, String date) {
        this.customer_id = customer_id;
        this.payment_id = payment_id;
        this.date = date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(String payment_id) {
        this.payment_id = payment_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
