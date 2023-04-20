package service;

import jakarta.ejb.Local;
import model.Member;

@Local
public interface MemberServiceI {

    void signUp(Member member);
}
