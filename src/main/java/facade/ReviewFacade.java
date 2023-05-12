package facade;

import jakarta.ejb.Stateless;
import model.Review;

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
}
