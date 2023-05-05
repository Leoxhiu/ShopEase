package facade;

import jakarta.ejb.Local;
import model.ReviewReply;

import java.util.List;

@Local
public interface ReviewReplyFacadeI {

    boolean createReviewReply(ReviewReply reviewReply);
    boolean editReviewReply(ReviewReply reviewReply);
    void removeReviewReply(ReviewReply reviewReply);
    List<ReviewReply> getAllReviewReply();
    List<ReviewReply> getRangeReviewReply(int[] range);
    ReviewReply getReviewReplyById(String id);
    int countReviewReply();
}
