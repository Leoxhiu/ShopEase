package service;

import jakarta.ejb.Local;
import model.Cart;

@Local
public interface CartServiceI {
    void create(Cart cart);
}
