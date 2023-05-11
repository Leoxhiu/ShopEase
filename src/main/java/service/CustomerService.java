package service;

import facade.AddressFacade;
import facade.CustomerFacade;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import model.Address;
import model.Customer;
import model.Member;
import model.Seller;

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

    @Override
    public boolean isAddressExists(String id) {
        Customer customer = customerFacade.getCustomerById(id);
        Address address = addressFacade.getAddressById(customer.getAddress().getId());
        return !address.getUnit().equals("") && !address.getAddress().equals("") && !address.getCity().equals("");
    }
}
