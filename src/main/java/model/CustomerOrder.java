package model;

import jakarta.persistence.*;
import org.eclipse.persistence.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Entity
@Cacheable(false)
@UuidGenerator(name = "CUSTOMERORDER_ID")
public class CustomerOrder {

    @Id
    @GeneratedValue (generator = "CUSTOMERORDER_ID")
    private String id;
    @ManyToOne // A customer can have many order
    @JoinColumn(name = "customerId", referencedColumnName = "id")
    private Customer customer;
    private double amount;
    private LocalDateTime date;

    public CustomerOrder() {
    }

    public CustomerOrder(Customer customer, double amount, LocalDateTime date) {
        this.customer = customer;
        this.amount = amount;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
