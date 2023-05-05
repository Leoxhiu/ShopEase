package service;

import facade.ReviewFacade;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import model.Review;

@Stateless (name = "ReviewService")
@LocalBean
public class ReviewService implements ReviewServiceI{

    @EJB
    private ReviewFacade reviewFacade;

    @Override
    public void create(Review review) {
        reviewFacade.createReview(review);
    }
}
