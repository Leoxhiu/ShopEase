package service;

import jakarta.ejb.Local;
import model.ReviewReply;

@Local
public interface ReviewReplyServiceI {

    void create(ReviewReply reviewReply);
}
