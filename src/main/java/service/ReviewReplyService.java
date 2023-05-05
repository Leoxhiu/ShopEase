package service;

import facade.ReviewReplyFacade;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import model.ReviewReply;

@Stateless (name = "ReviewReplyService")
@LocalBean
public class ReviewReplyService implements ReviewReplyServiceI {

    @EJB
    private ReviewReplyFacade reviewReplyFacade;

    @Override
    public void create(ReviewReply reviewReply) {
        reviewReplyFacade.createReviewReply(reviewReply);
    }
}
