package model;

import jakarta.persistence.*;
import org.eclipse.persistence.annotations.UuidGenerator;

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
    @OneToOne // An order can have only one payment
    @JoinColumn(name = "paymentId", referencedColumnName = "id")
    private Payment payment;
    private String date;

    public CustomerOrder() {
    }

    public CustomerOrder(Customer customer, Payment payment, String date) {
        this.customer = customer;
        this.payment = payment;
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

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
