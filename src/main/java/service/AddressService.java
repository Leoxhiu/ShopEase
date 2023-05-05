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
}
