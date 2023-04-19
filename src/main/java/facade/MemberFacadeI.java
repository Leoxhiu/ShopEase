package facade;

import jakarta.ejb.Local;
import model.Member;

import java.util.List;

@Local
public interface MemberFacadeI {

    boolean createMember(Member member);
    boolean editMember(Member member);
    void removeMember(Member member);
    List<Member> getAllMembers();
    List<Member> getRangeMembers(int[] range);
    Member getMemberbyId(String id);
    int countMembers();
    Member getMemberbyEmail(String email);
}
