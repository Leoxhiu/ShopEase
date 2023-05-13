package model;

import jakarta.persistence.*;
import org.eclipse.persistence.annotations.UuidGenerator;

@Entity
@Cacheable(false)
@UuidGenerator(name = "ORDERCART_ID")
public class OrderCart {

    @Id
    @GeneratedValue (generator = "ORDERCART_ID")
    private String id;
    @OneToOne // A cart (CustomerProduct) can be in one Order
    @JoinColumn(name = "cartId", referencedColumnName = "id")
    private Cart cart;
    @ManyToOne // A CustomerOrder can have many OrderCart (CustomerProduct)
    @JoinColumn(name = "orderId", referencedColumnName = "id")
    private CustomerOrder customerOrder;

    public OrderCart() {
    }

    public OrderCart(Cart cart, CustomerOrder customerOrder) {
        this.cart = cart;
        this.customerOrder = customerOrder;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }
}
