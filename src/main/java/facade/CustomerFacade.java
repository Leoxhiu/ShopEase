package facade;

import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import model.Customer;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

import java.util.List;

@Stateless
public class CustomerFacade extends AbstractFacade<Customer>{

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
    public List<Customer> getAllCustomer() {
        return this.findAll();
    }

    public List<Customer> getRangeCustomer(int[] range){
        return this.findRange(range);
    }

    public Customer getCustomerById(String id) {
        return this.find(id);
    }

    public int countCustomer(){
        return this.count();
    }

    public Customer getCustomerByMemberId(String memberId) {
        TypedQuery<Customer> query = em.createQuery(
                "SELECT c FROM Customer c WHERE c.member.id = :memberId", Customer.class);
        query.setParameter("memberId", memberId);
        query.setHint(QueryHints.REFRESH, HintValues.TRUE);
        List<Customer> customers = query.getResultList();

        return customers.isEmpty() ? null : customers.get(0);
    }
}