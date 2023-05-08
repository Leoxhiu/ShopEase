package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.eclipse.persistence.annotations.UuidGenerator;

@Entity
@UuidGenerator(name = "REVIEWREPLY_ID")
public class ReviewReply {

    @Id
    @GeneratedValue(generator = "REVIEWREPLY_ID")
    private String id;
    private String reviewId;
    private String customerId;
    private String sellerId;
    private String reply;

    public ReviewReply() {
    }

    public ReviewReply(String reviewId, String customerId, String sellerId, String reply) {
        this.reviewId = reviewId;
        this.customerId = customerId;
        this.sellerId = sellerId;
        this.reply = reply;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }
}
