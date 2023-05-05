package facade;

import jakarta.ejb.Local;
import model.CustomerOrder;

import java.util.List;

@Local
public interface CustomerOrderFacadeI {
    boolean createCustomerOrder(CustomerOrder customerOrder);
    boolean editCustomerOrder(CustomerOrder customerOrder);
    void removeCustomerOrder(CustomerOrder customerOrder);
    List<CustomerOrder> getAllCustomerOrder();
    List<CustomerOrder> getRangeCustomerOrder(int[] range);
    CustomerOrder getCustomerOrderById(String id);
    int countCustomerOrder();
}
