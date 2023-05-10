package service;

import jakarta.ejb.Local;
import model.Address;

@Local
public interface AddressServiceI {

    void create(Address address);
    boolean update(String addressId, String unit, String address, String city, String state, String postal);
}
