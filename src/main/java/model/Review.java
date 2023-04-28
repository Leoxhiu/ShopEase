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
    private String product_id;
    private int rating;
    private String feedback;

    public Review() {
    }

    public Review(String product_id, int rating, String feedback) {
        this.product_id = product_id;
        this.rating = rating;
        this.feedback = feedback;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
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
