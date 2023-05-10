package service;

import facade.AddressFacade;
import facade.CustomerFacade;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import model.Address;
import model.Customer;
import model.Member;

@Stateless(name = "CustomerService")
@LocalBean
public class CustomerService implements CustomerServiceI {

    @EJB
    private AddressFacade addressFacade;

    @EJB
    private CustomerFacade customerFacade;

    @Override
    public boolean signUp(Member member) {
        Address address = new Address("","", "", "", "");
        Customer customer = new Customer(member, address, 0);

        return addressFacade.createAddress(address) && customerFacade.createCustomer(customer);
    }
}
