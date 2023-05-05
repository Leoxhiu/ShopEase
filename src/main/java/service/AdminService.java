package service;

import facade.AdminFacade;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import model.Admin;

@Stateless(name = "AdminService")
@LocalBean
public class AdminService implements AdminServiceI{

    @EJB
    private AdminFacade adminFacade;

    @Override
    public void create(Admin admin) {
        adminFacade.createAdmin(admin);
    }
}
