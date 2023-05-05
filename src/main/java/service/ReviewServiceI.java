package service;

import jakarta.ejb.Local;
import model.Review;

@Local
public interface ReviewServiceI {

    void create(Review review);
}
