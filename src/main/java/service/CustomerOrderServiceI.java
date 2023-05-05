package service;

import jakarta.ejb.Local;
import model.CustomerOrder;

@Local
public interface CustomerOrderServiceI {
    void create(CustomerOrder customerOrder);
}
