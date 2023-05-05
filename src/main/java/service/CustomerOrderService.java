package service;

import facade.CustomerOrderFacade;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import model.CustomerOrder;

@Stateless(name = "CustomerOrderService")
@LocalBean
public class CustomerOrderService implements CustomerOrderServiceI{

    @EJB
    private CustomerOrderFacade customerOrderFacade;

    @Override
    public void create(CustomerOrder customerOrder) {
        customerOrderFacade.createCustomerOrder(customerOrder);
    }
}
