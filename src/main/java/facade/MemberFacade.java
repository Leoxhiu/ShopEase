package facade;

import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import model.Member;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

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
        query.setHint(QueryHints.REFRESH, HintValues.TRUE);
        List<Member> members = query.getResultList();

        return members.isEmpty() ? null : members.get(0);
    }

    public List<Member> getAllMemberByUserType(char userType) {
        TypedQuery<Member> query = super.em.createQuery(
                "SELECT m FROM Member m WHERE m.userType = :userType", Member.class);
        query.setParameter("userType", userType);
        query.setHint(QueryHints.REFRESH, HintValues.TRUE);
        return query.getResultList();
    }

    public List<Member> getAllActiveMember() {
        TypedQuery<Member> query = em.createQuery(
                "SELECT m FROM Member m WHERE m.isDeleted = 0", Member.class);
        query.setHint(QueryHints.REFRESH, HintValues.TRUE);
        return query.getResultList();
    }

    public List<Member> getAllActiveMemberBySearchTerm(String searchTerm) {
        TypedQuery<Member> query = em.createQuery(
                "SELECT m FROM Member m WHERE (LOWER(m.name) LIKE LOWER(:searchTerm) " +
                        "OR LOWER(m.email) LIKE LOWER(:searchTerm)) " +
                        "AND m.isDeleted = 0", Member.class);
        query.setParameter("searchTerm", "%" + searchTerm.toLowerCase() + "%");
        query.setHint(QueryHints.REFRESH, HintValues.TRUE);
        return query.getResultList();
    }

    public List<Member> filterMembersByUserType(String[] selectedUserTypes) {
        StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("SELECT m FROM Member m WHERE 1 = 1");

        // Add the selected user types condition
        if (selectedUserTypes != null && selectedUserTypes.length > 0) {
            queryBuilder.append(" AND (");
            for (int i = 0; i < selectedUserTypes.length; i++) {
                if (i > 0) {
                    queryBuilder.append(" OR");
                }
                queryBuilder.append(" m.userType = :userType").append(i);
            }
            queryBuilder.append(")");
        }

        // Add the remaining conditions and ordering logic from the original code
        queryBuilder.append(" AND m.isDeleted = 0");

        // Create and execute the query
        TypedQuery<Member> query = em.createQuery(queryBuilder.toString(), Member.class);
        query.setHint(QueryHints.REFRESH, HintValues.TRUE);

        // Set the parameter values for selected user types
        if (selectedUserTypes != null && selectedUserTypes.length > 0) {
            for (int i = 0; i < selectedUserTypes.length; i++) {
                query.setParameter("userType" + i, selectedUserTypes[i]);
            }
        }

        // Return the query results
        return query.getResultList();

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

    public boolean delete(String id){
        Member member = getMemberById(id);
        member.setDeleted(1);
        return editMember(member);
    }
}
