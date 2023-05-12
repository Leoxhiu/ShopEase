package facade;

import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import model.Member;

import java.util.List;

@Stateless
public class MemberFacade extends AbstractFacade<Member>{
    public MemberFacade() {
        super(Member.class);
    }

    public boolean createMember(Member member){
        try{
            this.create(member);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean editMember(Member member){
        try {
            this.edit(member);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public void removeMember(Member member){
        this.remove(member);
    }

    public List<Member> getAllMember() {
        return this.findAll();
    }

    public List<Member> getRangeMember(int[] range){
        return this.findRange(range);
    }

    public Member getMemberById(String id) {
        return this.find(id);
    }

    public int countMember(){
        return this.count();
    }

    public Member getMemberByEmail(String email) {
        TypedQuery<Member> query = super.em.createQuery(
                "SELECT m FROM Member m WHERE m.email = :email", Member.class);
        query.setParameter("email", email);
        List<Member> members = query.getResultList();
        return members.isEmpty() ? null : members.get(0);
    }

    public boolean isExist(String email) {

        Member member = getMemberByEmail(email);
        return member != null;
    }

    public boolean isValidPasswordLength(String password) {
        return password.length() >= 8;
    }

    public boolean isValidName(String name){
        return name.length() >= 2;
    }

    public boolean update(byte[] profile, String name, String email, String password) {
        Member member = getMemberByEmail(email);
        member.setProfile(profile);
        member.setName(name);
        member.setEmail(email);
        member.setPassword(password);
        return editMember(member);
    }

    public boolean updatePassword(String email, String password) {
        Member member = getMemberByEmail(email);
        member.setPassword(password);
        return editMember(member);
    }
}
