package model;

import jakarta.persistence.*;
import org.eclipse.persistence.annotations.UuidGenerator;

@Entity
@UuidGenerator(name = "REVIEWREPLY_ID")
public class ReviewReply {

    @Id
    @GeneratedValue(generator = "REVIEWREPLY_ID")
    private String id;
    @ManyToOne // A review can have many reply
    @JoinColumn(name = "reviewId", referencedColumnName = "id")
    private Review review;
    @OneToOne // A reply can from a customer
    @JoinColumn(name = "customerId", referencedColumnName = "id")
    private Customer customer;
    @OneToOne // A reply can from a seller
    @JoinColumn(name = "sellerId", referencedColumnName = "id")
    private Seller seller;
    private String reply;

    public ReviewReply() {
    }

    public ReviewReply(Review review, Customer customer, Seller seller, String reply) {
        this.review = review;
        this.customer = customer;
        this.seller = seller;
        this.reply = reply;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }
}
