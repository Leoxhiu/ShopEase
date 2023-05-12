package facade;

import jakarta.ejb.Stateless;
import model.ReviewReply;

import java.util.List;

@Stateless
public class ReviewReplyFacade extends AbstractFacade<ReviewReply>{
    public ReviewReplyFacade() {
        super(ReviewReply.class);
    }

    public boolean createReviewReply(ReviewReply reviewReply) {
        try{
            this.create(reviewReply);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean editReviewReply(ReviewReply reviewReply) {
        try{
            this.edit(reviewReply);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public void removeReviewReply(ReviewReply reviewReply) {
        this.remove(reviewReply);
    }

    public List<ReviewReply> getAllReviewReply() {
        return this.findAll();
    }

    public List<ReviewReply> getRangeReviewReply(int[] range) {
        return this.findRange(range);
    }

    public ReviewReply getReviewReplyById(String id) {
        return this.find(id);
    }

    public int countReviewReply() {
        return this.count();
    }
}
