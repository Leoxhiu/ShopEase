package service;

import jakarta.ejb.Local;
import model.Discount;

@Local
public interface DiscountServiceI {

    void create(Discount discount);
}