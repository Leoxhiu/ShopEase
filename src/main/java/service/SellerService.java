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
    public boolean isBankAccountExist(String id) {
        Seller seller = sellerFacade.getSellerById(id);
        return seller != null && !seller.getBankAccount().equals("");
    }

    @Override
    public boolean isAddressExists(String id) {
        Seller seller = sellerFacade.getSellerById(id);
        Address address = addressFacade.getAddressById(seller.getAddress().getId());
        return !address.getUnit().equals("") && !address.getAddress().equals("") && !address.getCity().equals("");
    }

    @Override
    public boolean signUp(Member member) {
        Address address = new Address("", "","", "", "");
        Seller seller = new Seller(member, address, "", 0, false);
        return addressFacade.createAddress(address) && sellerFacade.createSeller(seller);
    }

    @Override
    public boolean updateBankAccount(String sellerId, String bankAccount) {

        Seller seller = sellerFacade.getSellerById(sellerId);
        seller.setBankAccount(bankAccount);
        return sellerFacade.editSeller(seller);
    }
}