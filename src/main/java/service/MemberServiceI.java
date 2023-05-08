package service;

import jakarta.ejb.Local;
import model.Member;

@Local
public interface MemberServiceI {

    boolean signUp(Member member);
}
