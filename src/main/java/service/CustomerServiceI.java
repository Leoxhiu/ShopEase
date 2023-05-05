package service;

import jakarta.ejb.Local;
import model.Customer;

@Local
public interface CustomerServiceI {

    void signUp(Customer customer);
}
