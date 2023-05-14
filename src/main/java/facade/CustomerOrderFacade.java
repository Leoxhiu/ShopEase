package facade;

import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import model.CustomerOrder;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

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

    public List<CustomerOrder> getAllCustomerOrderByCustomerIdDESC(String customerId){
        TypedQuery<CustomerOrder> query = em.createQuery(
                "SELECT c FROM CustomerOrder c WHERE c.customer.id = :customerId ORDER BY c.date DESC", CustomerOrder.class);
        query.setParameter("customerId", customerId);
        query.setHint(QueryHints.REFRESH, HintValues.TRUE);
        return query.getResultList();
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