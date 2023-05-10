package service;


import facade.AddressFacade;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import model.Address;

@Stateless(name = "AddressService")
@LocalBean
public class AddressService implements AddressServiceI{

    @EJB
    private AddressFacade addressFacade;

    @Override
    public void create(Address address) {
        addressFacade.createAddress(address);
    }

    @Override
    public boolean update(String addressId, String unit, String address, String city, String state, String postal) {
        Address memberAddress = addressFacade.getAddressById(addressId);
        memberAddress.setUnit(unit);
        memberAddress.setAddress(address);
        memberAddress.setCity(city);
        memberAddress.setState(state);
        memberAddress.setPostal(postal);
        return addressFacade.editAddress(memberAddress);
    }
}