package facade;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import model.Member;

import java.util.List;

@Stateless(name = "MemberFacade")
@LocalBean
public class MemberFacade extends AbstractFacade<Member> implements MemberFacadeI{
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

}
