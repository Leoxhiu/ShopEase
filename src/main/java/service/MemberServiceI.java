package service;

import jakarta.ejb.Local;
import model.Member;

@Local
public interface MemberServiceI {

    String getFrontEmail(String email);
    void signUp(Member member);
}
