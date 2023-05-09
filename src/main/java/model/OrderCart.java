package model;

import jakarta.persistence.*;
import org.eclipse.persistence.annotations.UuidGenerator;

@Entity
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
    private double price;
    private int deliveryStatus;

    public OrderCart() {
    }


}
