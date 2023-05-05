package facade;

import jakarta.ejb.Local;
import model.Address;

import java.util.List;

@Local
public interface AddressFacadeI {
    boolean createAddress(Address address);
    boolean editAddress(Address address);
    void removeAddress(Address address);
    List<Address> getAllAddress();
    List<Address> getRangeAddress(int[] range);
    Address getAddressById(String id);
    int countAddress();
}
