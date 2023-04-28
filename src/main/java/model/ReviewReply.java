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
    private String review_id;
    private String customer_id;
    private String seller_id;
    private String reply;

    public ReviewReply() {
    }

    public ReviewReply(String review_id, String customer_id, String seller_id, String reply) {
        this.review_id = review_id;
        this.customer_id = customer_id;
        this.seller_id = seller_id;
        this.reply = reply;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getReview_id() {
        return review_id;
    }

    public void setReview_id(String review_id) {
        this.review_id = review_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }
}
