package service;

import jakarta.ejb.Local;
import model.Member;

@Local
public interface MemberServiceI {

    boolean isExist(String email);
    boolean isValidPasswordLength(String password);
    boolean isValidName(String name);
    boolean signUp(Member member);
    boolean update(byte[] profile, String name, String email, String password);
    boolean updatePassword(String email, String password);
}
