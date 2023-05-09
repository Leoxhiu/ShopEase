package service;

import jakarta.ejb.Local;
import model.Member;

@Local
public interface MemberServiceI {

    boolean isExist(String email);
    boolean signUp(Member member);

}
