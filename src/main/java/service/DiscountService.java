package service;

import facade.DiscountFacade;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import model.Discount;

@Stateless(name = "DiscountService")
@LocalBean
public class DiscountService implements DiscountServiceI{

    @EJB
    private DiscountFacade discountFacade;

    @Override
    public void create(Discount discount) {
        discountFacade.createDiscount(discount);
    }
}
