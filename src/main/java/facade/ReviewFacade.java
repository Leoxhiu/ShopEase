package facade;

import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import model.Review;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

import java.util.List;

@Stateless
public class ReviewFacade extends AbstractFacade<Review>{

    public ReviewFacade() {
        super(Review.class);
    }

    public boolean createReview(Review review) {
        try{
            this.create(review);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean editReview(Review review) {
        try{
            this.edit(review);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public void removeReview(Review review) {
        this.remove(review);
    }

    public List<Review> getAllReview() {
        return this.findAll();
    }

    public List<Review> getRangeReview(int[] range) {
        return this.findRange(range);
    }

    public Review getReviewById(String id) {
        return this.find(id);
    }

    public int countReview() {
        return this.count();
    }

    public boolean update(String reviewId, int rating, String feedback){
        Review review = getReviewById(reviewId);
        review.setRating(rating);
        review.setFeedback(feedback);
        return editReview(review);
    }

    public Review getReviewByCartId(String cartId) {
        TypedQuery<Review> query = em.createQuery(
                "SELECT r FROM Review r WHERE r.cart.id = :cartId", Review.class);
        query.setParameter("cartId", cartId);
        query.setHint(QueryHints.REFRESH, HintValues.TRUE);
        List<Review> reviews = query.getResultList();
        if (reviews.isEmpty()) {
            return null;
        }
        return reviews.get(0);
    }

    public int countReviewsByRating(int rating) {
        TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(r) FROM Review r WHERE r.rating = :rating", Long.class);
        query.setParameter("rating", rating);
        query.setHint(QueryHints.REFRESH, HintValues.TRUE);
        Long count = query.getSingleResult();
        return count.intValue();
    }

}
