package model;

import jakarta.persistence.*;
import org.eclipse.persistence.annotations.UuidGenerator;

@Entity
@Cacheable(false)
@UuidGenerator(name = "PAYMENT_ID")
public class Payment {

    @Id
    @GeneratedValue(generator = "PAYMENT_ID")
    private String id;
    @OneToOne // An order can have one payment
    @JoinColumn(name = "orderId", referencedColumnName = "id")
    private CustomerOrder customerOrder;
    private double price;

    public Payment() {
    }

    public Payment(CustomerOrder customerOrder, double price) {
        this.customerOrder = customerOrder;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
