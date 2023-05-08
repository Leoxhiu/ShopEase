package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.eclipse.persistence.annotations.UuidGenerator;

@Entity
@UuidGenerator(name = "REVIEW_ID")
public class Review {

    @Id
    @GeneratedValue(generator = "REVIEW_ID")
    private String id;
    private String productId;
    private int rating;
    private String feedback;

    public Review() {
    }

    public Review(String productId, int rating, String feedback) {
        this.productId = productId;
        this.rating = rating;
        this.feedback = feedback;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
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
