package facade;

import jakarta.ejb.Local;
import model.Discount;

import java.util.List;

@Local
public interface DiscountFacadeI {
    boolean createDiscount(Discount discount);
    boolean editDiscount(Discount discount);
    void removeDiscount(Discount discount);
    List<Discount> getAllDiscount();
    List<Discount> getRangeDiscount(int[] range);
    Discount getDiscountById(String id);
    int countDiscount();

}
