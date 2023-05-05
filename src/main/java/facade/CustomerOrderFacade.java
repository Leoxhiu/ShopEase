package facade;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import model.CustomerOrder;

import java.util.List;

@Stateless(name = "CustomerOrderFacade")
@LocalBean
public class CustomerOrderFacade extends AbstractFacade<CustomerOrder> implements CustomerOrderFacadeI{
    public CustomerOrderFacade() {
        super(CustomerOrder.class);
    }

    @Override
    public boolean createCustomerOrder(CustomerOrder customerOrder) {
        try{
            this.create(customerOrder);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean editCustomerOrder(CustomerOrder customerOrder) {
        try{
            this.edit(customerOrder);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public void removeCustomerOrder(CustomerOrder customerOrder) {
        this.remove(customerOrder);
    }

    @Override
    public List<CustomerOrder> getAllCustomerOrder() {
        return this.findAll();
    }

    @Override
    public List<CustomerOrder> getRangeCustomerOrder(int[] range) {
        return this.findRange(range);
    }

    @Override
    public CustomerOrder getCustomerOrderById(String id) {
        return this.find(id);
    }

    @Override
    public int countCustomerOrder() {
        return this.count();
    }
}