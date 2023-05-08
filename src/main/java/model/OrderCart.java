package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.eclipse.persistence.annotations.UuidGenerator;

@Entity
@UuidGenerator(name = "ORDERCART_ID")
public class OrderCart {


    @Id
    @GeneratedValue (generator = "ORDERCART_ID")
    private String id;
    private String cartId;
    private String orderId;
    private double price;
    private int deliveryStatus;

    public OrderCart() {
    }

    public OrderCart(String cartId, String orderId, double price, int deliveryStatus) {
        this.cartId = cartId;
        this.orderId = orderId;
        this.price = price;
        this.deliveryStatus = deliveryStatus;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
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

    public int getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(int deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
}
