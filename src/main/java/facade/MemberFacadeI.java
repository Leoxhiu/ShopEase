package facade;

import jakarta.ejb.Local;
import model.Member;

import java.util.List;

@Local
public interface MemberFacadeI {

    boolean createMember(Member member);
    boolean editMember(Member member);
    void removeMember(Member member);
    List<Member> getAllMember();
    List<Member> getRangeMember(int[] range);
    Member getMemberById(String id);
    int countMember();
    Member getMemberByEmail(String email);
}
