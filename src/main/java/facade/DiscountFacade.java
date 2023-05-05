package facade;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import model.Discount;

import java.util.List;

@Stateless(name = "DiscountFacade")
@LocalBean
public class DiscountFacade extends AbstractFacade<Discount> implements DiscountFacadeI{

    public DiscountFacade() {
        super(Discount.class);
    }

    @Override
    public boolean createDiscount(Discount discount) {
        try{
            this.create(discount);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean editDiscount(Discount discount) {
        try{
            this.edit(discount);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public void removeDiscount(Discount discount) {
        this.remove(discount);
    }

    @Override
    public List<Discount> getAllDiscount() {
        return this.findAll();
    }

    @Override
    public List<Discount> getRangeDiscount(int[] range) {
        return this.findRange(range);
    }

    @Override
    public Discount getDiscountById(String id) {
        return this.find(id);
    }

    @Override
    public int countDiscount() {
        return this.count();
    }
}
