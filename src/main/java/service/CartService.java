package service;

import facade.CartFacade;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import model.Cart;

@Stateless(name = "CartService")
@LocalBean
public class CartService implements CartServiceI{

    @EJB
    private CartFacade cartFacade;

    @Override
    public void create(Cart cart) {
        cartFacade.createCart(cart);
    }
}
