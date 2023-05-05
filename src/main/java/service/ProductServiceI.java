package service;

import jakarta.ejb.Local;
import model.Product;

@Local
public interface ProductServiceI {

    void create(Product product);
}
