package facade;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import model.Customer;

import java.util.List;

@Stateless(name = "CustomerFacade")
@LocalBean
public class CustomerFacade extends AbstractFacade<Customer> implements CustomerFacadeI{

    public CustomerFacade() {
        super(Customer.class);
    }

    public boolean createCustomer(Customer customer){
        try{
            this.create(customer);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean editCustomer(Customer customer){
        try {
            this.edit(customer);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public void removeCustomer(Customer customer){
        this.remove(customer);
    }
    public List<Customer> getAllCustomers() {
        return this.findAll();
    }

    public List<Customer> getRangeCustomers(int[] range){
        return this.findRange(range);
    }

    public Customer getCustomerbyId(String id) {
        return this.find(id);
    }

    public int countCustomers(){
        return this.count();
    }

    @Override
    public int add() {
        return 5;
    }
}