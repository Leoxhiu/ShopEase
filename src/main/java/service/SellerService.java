package service;

import facade.SellerFacade;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import model.Seller;

@Stateless(name = "SellerService")
@LocalBean
public class SellerService implements SellerServiceI {

    @EJB
    private SellerFacade sellerFacade;

    @Override
    public void create(Seller seller) {
        sellerFacade.createSeller(seller);
    }
}
