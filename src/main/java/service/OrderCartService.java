package service;

import facade.OrderCartFacade;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import model.OrderCart;

@Stateless (name = "OrderCartService")
@LocalBean
public class OrderCartService implements OrderCartServiceI {

    @EJB
    private OrderCartFacade orderCartFacade;

    @Override
    public void create(OrderCart orderCart) {
        orderCartFacade.createOrderCart(orderCart);
    }
}
