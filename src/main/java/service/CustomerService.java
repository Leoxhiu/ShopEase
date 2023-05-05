package service;

import facade.CustomerFacade;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import model.Customer;

@Stateless(name = "CustomerService")
@LocalBean
public class CustomerService implements CustomerServiceI{

    @EJB
    private CustomerFacade customerFacade;

    @Override
    public void signUp(Customer customer) {
        customerFacade.createCustomer(customer);
    }
}
