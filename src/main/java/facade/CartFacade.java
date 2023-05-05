package facade;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import model.Cart;

import java.util.List;

@Stateless(name = "CartFacade")
@LocalBean
public class CartFacade extends AbstractFacade<Cart> implements CartFacadeI{
    public CartFacade() {
        super(Cart.class);
    }

    @Override
    public boolean createCart(Cart cart) {
        try{
            this.create(cart);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean editCart(Cart cart) {
        try{
            this.edit(cart);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public void removeCart(Cart cart) {
        this.remove(cart);
    }

    @Override
    public List<Cart> getAllCart() {
        return this.findAll();
    }

    @Override
    public List<Cart> getRangeCart(int[] range) {
        return this.findRange(range);
    }

    @Override
    public Cart getCartById(String id) {
        return this.find(id);
    }

    @Override
    public int countCart() {
        return this.count();
    }
}
