package facade;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import model.ReviewReply;

import java.util.List;

@Stateless (name = "ReviewReplyFacade")
@LocalBean
public class ReviewReplyFacade extends AbstractFacade<ReviewReply> implements ReviewReplyFacadeI {
    public ReviewReplyFacade() {
        super(ReviewReply.class);
    }

    @Override
    public boolean createReviewReply(ReviewReply reviewReply) {
        try{
            this.create(reviewReply);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean editReviewReply(ReviewReply reviewReply) {
        try{
            this.edit(reviewReply);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public void removeReviewReply(ReviewReply reviewReply) {
        this.remove(reviewReply);
    }

    @Override
    public List<ReviewReply> getAllReviewReply() {
        return this.findAll();
    }

    @Override
    public List<ReviewReply> getRangeReviewReply(int[] range) {
        return this.findRange(range);
    }

    @Override
    public ReviewReply getReviewReplyById(String id) {
        return this.find(id);
    }

    @Override
    public int countReviewReply() {
        return this.count();
    }
}
