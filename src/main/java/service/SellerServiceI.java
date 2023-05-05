package service;

import jakarta.ejb.Local;
import model.Seller;

@Local
public interface SellerServiceI {

    void create(Seller seller);
}
