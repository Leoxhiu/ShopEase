package service;

import jakarta.ejb.Local;
import model.Member;

@Local
public interface SellerServiceI {

    boolean signUp(Member member);
}
