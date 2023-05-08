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
    private String customerId;
    private String paymentId;
    private String date;

    public CustomerOrder() {
    }

    public CustomerOrder(String customerId, String paymentId, String date) {
        this.customerId = customerId;
        this.paymentId = paymentId;
        this.date = date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
