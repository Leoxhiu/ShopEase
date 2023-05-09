package model;

import jakarta.persistence.*;
import org.eclipse.persistence.annotations.UuidGenerator;

@Entity
@UuidGenerator(name = "REVIEW_ID")
public class Review {

    @Id
    @GeneratedValue(generator = "REVIEW_ID")
    private String id;
    @ManyToOne // A product can have many review
    @JoinColumn(name = "productId", referencedColumnName = "id")
    private Product product;
    private int rating;
    private String feedback;

    public Review() {
    }

    public Review(Product product, int rating, String feedback) {
        this.product = product;
        this.rating = rating;
        this.feedback = feedback;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
