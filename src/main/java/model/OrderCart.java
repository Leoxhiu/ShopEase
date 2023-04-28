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
    private String cart_id;
    private String order_id;
    private double price;
    private int delivery_status;

    public OrderCart() {
    }

    public OrderCart(String cart_id, String order_id, double price, int delivery_status) {
        this.cart_id = cart_id;
        this.order_id = order_id;
        this.price = price;
        this.delivery_status = delivery_status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getCart_id() {
        return cart_id;
    }

    public void setCart_id(String cart_id) {
        this.cart_id = cart_id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDelivery_status() {
        return delivery_status;
    }

    public void setDelivery_status(int delivery_status) {
        this.delivery_status = delivery_status;
    }
}
