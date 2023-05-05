package service;

import jakarta.ejb.Local;
import model.OrderCart;

@Local
public interface OrderCartServiceI {

    void create(OrderCart orderCart);
}
