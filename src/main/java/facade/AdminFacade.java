package facade;

import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import model.Admin;

import java.util.List;

@Stateless
public class AdminFacade extends AbstractFacade<Admin>{

    public AdminFacade() {
        super(Admin.class);
    }

    public boolean createAdmin(Admin admin) {
        try {
            this.create(admin);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean editAdmin(Admin admin) {
        try {
            this.edit(admin);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void removeAdmin(Admin admin) {
        this.remove(admin);
    }

    public List<Admin> getAllAdmin() {
        return this.findAll();
    }

    public List<Admin> getRangeAdmin(int[] range) {
        return this.findRange(range);
    }

    public Admin getAdminById(String id) {
        return this.find(id);
    }

    public int countAdmin() {
        return this.count();
    }

    public Admin getAdminByMemberId(String memberId) {
            TypedQuery<Admin> query = em.createQuery(
                    "SELECT a FROM Admin a WHERE a.member.id = :memberId", Admin.class);
            query.setParameter("memberId", memberId);
            List<Admin> admins = query.getResultList();
            return admins.isEmpty() ? null : admins.get(0);
    }
}
