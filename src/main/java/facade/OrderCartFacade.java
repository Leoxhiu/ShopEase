package facade;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import model.OrderCart;

import java.util.List;

@Stateless(name = "OrderCartFacade")
@LocalBean
public class OrderCartFacade extends AbstractFacade<OrderCart> implements OrderCartFacadeI {
    public OrderCartFacade() {
        super(OrderCart.class);
    }

    @Override
    public boolean createOrderCart(OrderCart orderCart) {
        try{
            this.create(orderCart);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean editOrderCart(OrderCart orderCart) {
        try{
            this.edit(orderCart);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public void removeOrderCart(OrderCart orderCart) {
        this.remove(orderCart);
    }

    @Override
    public List<OrderCart> getAllOrderCart() {
        return this.findAll();
    }

    @Override
    public List<OrderCart> getRangeOrderCart(int[] range) {
        return this.findRange(range);
    }

    @Override
    public OrderCart getOrderCartById(String id) {
        return this.find(id);
    }

    @Override
    public int countOrderCart() {
        return this.count();
    }
}
