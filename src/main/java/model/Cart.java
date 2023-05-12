package model;

import jakarta.persistence.*;
import org.eclipse.persistence.annotations.UuidGenerator;

@Entity
@UuidGenerator(name = "CART_ID")
public class Cart {
    @Id
    @GeneratedValue(generator = "CART_ID")
    private String id;
    @ManyToOne // A customer can have many cart
    @JoinColumn(name = "customerId", referencedColumnName = "id")
    private Customer customer;
    @ManyToOne // A product can be in many cart
    @JoinColumn(name = "productId", referencedColumnName = "id")
    private Product product;
    private int quantity;
    private double price;

    private int isPurchased; // is the cart purchased

    public Cart() {
    }

    public Cart(Customer customer, Product product, int quantity, double price, int isPurchased) {
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.isPurchased = isPurchased;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getIsPurchased() {
        return isPurchased;
    }

    public void setPurchased(int purchased) {
        isPurchased = purchased;
    }
}
