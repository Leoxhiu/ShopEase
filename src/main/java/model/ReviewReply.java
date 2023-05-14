package model;

import jakarta.persistence.*;
import org.eclipse.persistence.annotations.UuidGenerator;

@Entity
@Cacheable(false)
@UuidGenerator(name = "REVIEWREPLY_ID")
public class ReviewReply {

    @Id
    @GeneratedValue(generator = "REVIEWREPLY_ID")
    private String id;
    @ManyToOne // A review can have many reply
    @JoinColumn(name = "reviewId", referencedColumnName = "id")
    private Review review;
    @OneToOne // A reply can from a member
    @JoinColumn(name = "memberId", referencedColumnName = "id")
    private Member member;
    private String reply;

    public ReviewReply() {
    }

    public ReviewReply(Review review, Member member, String reply) {
        this.review = review;
        this.member = member;
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

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }
}
