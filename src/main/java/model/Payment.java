package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.eclipse.persistence.annotations.UuidGenerator;

@Entity
@UuidGenerator(name = "PAYMENT_ID")
public class Payment {

    @Id
    @GeneratedValue(generator = "PAYMENT_ID")
    private String id;
    private String orderId;
    private double price;

    public Payment() {
    }

    public Payment(String orderId, double price) {
        this.orderId = orderId;
        this.price = price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
