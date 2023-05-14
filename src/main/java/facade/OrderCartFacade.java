package facade;

import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import model.CustomerOrder;
import model.OrderCart;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

import java.util.List;

@Stateless
public class OrderCartFacade extends AbstractFacade<OrderCart>{
    public OrderCartFacade() {
        super(OrderCart.class);
    }

    public boolean createOrderCart(OrderCart orderCart) {
        try{
            this.create(orderCart);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean editOrderCart(OrderCart orderCart) {
        try{
            this.edit(orderCart);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public void removeOrderCart(OrderCart orderCart) {
        this.remove(orderCart);
    }

    public List<OrderCart> getAllOrderCart() {
        return this.findAll();
    }

    public List<OrderCart> getAllOrderCartByCustomerOrderId(String customerOrderId) {
        TypedQuery<OrderCart> query = em.createQuery(
                "SELECT o FROM OrderCart o WHERE o.customerOrder.id = :customerOrderId", OrderCart.class);
        query.setParameter("customerOrderId", customerOrderId);
        query.setHint(QueryHints.REFRESH, HintValues.TRUE);
        return query.getResultList();
    }

    public List<OrderCart> getRangeOrderCart(int[] range) {
        return this.findRange(range);
    }

    public OrderCart getOrderCartById(String id) {
        return this.find(id);
    }

    public int countOrderCart() {
        return this.count();
    }
}
