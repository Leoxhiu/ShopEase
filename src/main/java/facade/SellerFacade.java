package facade;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import model.Seller;

import java.util.List;

@Stateless(name = "SellerFacade")
@LocalBean
public class SellerFacade extends AbstractFacade<Seller> implements SellerFacadeI{
    public SellerFacade() {
        super(Seller.class);
    }

    @Override
    public boolean createSeller(Seller seller) {
        try{
            this.create(seller);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean editSeller(Seller seller) {
        try{
            this.edit(seller);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public void removeSeller(Seller seller) {
        this.remove(seller);
    }

    @Override
    public List<Seller> getAllSeller() {
        return this.findAll();
    }

    @Override
    public List<Seller> getRangeSeller(int[] range) {
        return this.findRange(range);
    }

    @Override
    public Seller getSellerById(String id) {
        return this.find(id);
    }

    @Override
    public int countSeller() {
        return this.count();
    }
}
