package service;

import jakarta.ejb.Local;
import model.Admin;

@Local
public interface AdminServiceI {

    void create(Admin admin);
}
