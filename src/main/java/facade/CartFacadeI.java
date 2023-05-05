package facade;

import jakarta.ejb.Local;
import model.Cart;

import java.util.List;

@Local
public interface CartFacadeI {
    boolean createCart(Cart cart);
    boolean editCart(Cart cart);
    void removeCart(Cart cart);
    List<Cart> getAllCart();
    List<Cart> getRangeCart(int[] range);
    Cart getCartById(String id);
    int countCart();
}
