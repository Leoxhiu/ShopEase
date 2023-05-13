package model;

import jakarta.persistence.*;
import org.eclipse.persistence.annotations.UuidGenerator;

@Entity
@Cacheable(false)
@UuidGenerator(name = "REVIEW_ID")
public class Review {

    @Id
    @GeneratedValue(generator = "REVIEW_ID")
    private String id;
    @OneToOne // A cart can have a main review from customer
    @JoinColumn(name = "cartId", referencedColumnName = "id")
    private Cart cart;
    private int rating;
    private String feedback;

    public Review() {
    }

    public Review(Cart cart, int rating, String feedback) {
        this.cart = cart;
        this.rating = rating;
        this.feedback = feedback;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
