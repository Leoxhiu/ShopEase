package facade;

import jakarta.ejb.Local;
import model.Seller;

import java.util.List;

@Local
public interface SellerFacadeI {
    boolean createSeller(Seller seller);
    boolean editSeller(Seller seller);
    void removeSeller(Seller seller);
    List<Seller> getAllSeller();
    List<Seller> getRangeSeller(int[] range);
    Seller getSellerById(String id);
    int countSeller();
    Seller getSellerByMemberId(String memberId);
}
