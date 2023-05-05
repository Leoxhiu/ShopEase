package service;

import jakarta.ejb.Local;
import model.Address;

@Local
public interface AddressServiceI {

    void create(Address address);
}
