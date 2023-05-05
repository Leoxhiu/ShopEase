package facade;

import jakarta.ejb.Local;
import model.Review;

import java.util.List;

@Local
public interface ReviewFacadeI {
    boolean createReview(Review review);
    boolean editReview(Review review);
    void removeReview(Review review);
    List<Review> getAllReview();
    List<Review> getRangeReview(int[] range);
    Review getReviewById(String id);
    int countReview();
}
