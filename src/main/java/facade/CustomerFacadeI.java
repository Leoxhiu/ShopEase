package facade;

import jakarta.ejb.Local;
import model.Customer;

import java.util.List;

@Local
public interface CustomerFacadeI {

    boolean createCustomer(Customer customer);
    boolean editCustomer(Customer customer);
    void removeCustomer(Customer customer);
    List<Customer> getAllCustomer();
    List<Customer> getRangeCustomer(int[] range);
    Customer getCustomerById(String id);
    int countCustomer();
    Customer getCustomerByMemberId(String memberId);
}
