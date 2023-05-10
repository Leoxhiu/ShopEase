package facade;

import jakarta.ejb.Local;
import model.Admin;

import java.util.List;

@Local
public interface AdminFacadeI {
    boolean createAdmin(Admin admin);

    boolean editAdmin(Admin admin);

    void removeAdmin(Admin admin);

    List<Admin> getAllAdmin();

    List<Admin> getRangeAdmin(int[] range);

    Admin getAdminById(String id);

    int countAdmin();

    Admin getAdminByMemberId(String memberId);
}
