package facade;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import model.Admin;

import java.util.List;

@Stateless(name = "AdminFacade")
@LocalBean
public class AdminFacade extends AbstractFacade<Admin> implements AdminFacadeI{

    public AdminFacade() {
        super(Admin.class);
    }

    @Override
    public boolean createAdmin(Admin admin) {
        try{
            this.create(admin);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean editAdmin(Admin admin) {
        try {
            this.edit(admin);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public void removeAdmin(Admin admin) {
        this.remove(admin);
    }

    @Override
    public List<Admin> getAllAdmin() {
        return this.findAll();
    }

    @Override
    public List<Admin> getRangeAdmin(int[] range) {
        return this.findRange(range);
    }

    @Override
    public Admin getAdminById(String id) {
        return this.find(id);
    }

    @Override
    public int countAdmin() {
        return this.count();
    }
}