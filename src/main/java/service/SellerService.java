package service;

import facade.AddressFacade;
import facade.SellerFacade;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import model.Address;
import model.Member;
import model.Seller;

@Stateless(name = "SellerService")
@LocalBean
public class SellerService implements SellerServiceI {

    @EJB
    private SellerFacade sellerFacade;

    @EJB
    private AddressFacade addressFacade;

    @Override
    public boolean signUp(Member member) {
        Address address = new Address("", "", "");
        Seller seller = new Seller(member, address, "", 0, false);
        return addressFacade.createAddress(address) && sellerFacade.createSeller(seller);
    }
}
