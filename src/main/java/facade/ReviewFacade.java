package facade;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import model.Review;

import java.util.List;

@Stateless (name = "ReviewFacade")
@LocalBean
public class ReviewFacade extends AbstractFacade<Review> implements ReviewFacadeI {

    public ReviewFacade() {
        super(Review.class);
    }

    @Override
    public boolean createReview(Review review) {
        try{
            this.create(review);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean editReview(Review review) {
        try{
            this.edit(review);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public void removeReview(Review review) {
        this.remove(review);
    }

    @Override
    public List<Review> getAllReview() {
        return this.findAll();
    }

    @Override
    public List<Review> getRangeReview(int[] range) {
        return this.findRange(range);
    }

    @Override
    public Review getReviewById(String id) {
        return this.find(id);
    }

    @Override
    public int countReview() {
        return this.count();
    }
}
