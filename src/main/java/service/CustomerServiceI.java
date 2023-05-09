package service;

import jakarta.ejb.Local;
import model.Member;

@Local
public interface CustomerServiceI {

    boolean signUp(Member member);
}
