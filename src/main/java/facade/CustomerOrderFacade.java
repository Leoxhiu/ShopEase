package facade;

import jakarta.ejb.Stateless;
import model.CustomerOrder;

import java.util.List;

@Stateless
public class CustomerOrderFacade extends AbstractFacade<CustomerOrder>{
    public CustomerOrderFacade() {
        super(CustomerOrder.class);
    }

    public boolean createCustomerOrder(CustomerOrder customerOrder) {
        try{
            this.create(customerOrder);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean editCustomerOrder(CustomerOrder customerOrder) {
        try{
            this.edit(customerOrder);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public void removeCustomerOrder(CustomerOrder customerOrder) {
        this.remove(customerOrder);
    }

    public List<CustomerOrder> getAllCustomerOrder() {
        return this.findAll();
    }

    public List<CustomerOrder> getRangeCustomerOrder(int[] range) {
        return this.findRange(range);
    }

    public CustomerOrder getCustomerOrderById(String id) {
        return this.find(id);
    }

    public int countCustomerOrder() {
        return this.count();
    }
}