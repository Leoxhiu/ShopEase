package facade;

import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import model.ReviewReply;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

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

    public List<ReviewReply> getReviewReplyByReviewId(String reviewId){
        TypedQuery<ReviewReply> query = em.createQuery(
                "SELECT rr FROM ReviewReply rr WHERE rr.review.id = :reviewId", ReviewReply.class);
        query.setParameter("reviewId", reviewId);
        query.setHint(QueryHints.REFRESH, HintValues.TRUE);
        return query.getResultList();
    }
}
