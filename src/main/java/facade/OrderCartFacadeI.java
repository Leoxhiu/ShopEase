package facade;

import jakarta.ejb.Local;
import model.OrderCart;

import java.util.List;

@Local
public interface OrderCartFacadeI {
    boolean createOrderCart(OrderCart orderCart);
    boolean editOrderCart(OrderCart orderCart);
    void removeOrderCart(OrderCart orderCart);
    List<OrderCart> getAllOrderCart();
    List<OrderCart> getRangeOrderCart(int[] range);
    OrderCart getOrderCartById(String id);
    int countOrderCart();
}
