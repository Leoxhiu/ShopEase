package facade;

import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import model.Cart;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

import java.util.List;

@Stateless
public class CartFacade extends AbstractFacade<Cart> {
    public CartFacade() {
        super(Cart.class);
    }

    public boolean createCart(Cart cart) {
        try {
            this.create(cart);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean editCart(Cart cart) {
        try {
            this.edit(cart);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void removeCart(Cart cart) {
        this.remove(cart);
    }

    public List<Cart> getAllCart() {
        return this.findAll();
    }

    public List<Cart> getRangeCart(int[] range) {
        return this.findRange(range);
    }

    public Cart getCartById(String id) {
        return this.find(id);
    }

    public int countCart() {
        return this.count();
    }

    public int countCartByCustomerId(String customerId) {
        TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(c) FROM Cart c WHERE c.customer.id = :customerId", Long.class);
        query.setParameter("customerId", customerId);
        query.setHint(QueryHints.REFRESH, HintValues.TRUE);
        Long count = query.getSingleResult();
        return count.intValue();
    }

    public List<Cart> getActiveCartByCustomerId(String customerId) {
        TypedQuery<Cart> query = em.createQuery(
                "SELECT c FROM Cart c WHERE c.isPurchased = 0 AND c.customer.id = :customerId", Cart.class);
        query.setParameter("customerId", customerId);
        query.setHint(QueryHints.REFRESH, HintValues.TRUE);
        List<Cart> carts = query.getResultList();
        return carts;
    }

    public boolean delete(String id) {
        Cart cart = getCartById(id);
        try{
            removeCart(cart);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}