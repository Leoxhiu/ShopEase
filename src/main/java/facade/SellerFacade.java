package facade;

import jakarta.ejb.Stateless;
import jakarta.persistence.TypedQuery;
import model.Seller;
import org.eclipse.persistence.config.HintValues;
import org.eclipse.persistence.config.QueryHints;

import java.util.List;

@Stateless
public class SellerFacade extends AbstractFacade<Seller>{
    public SellerFacade() {
        super(Seller.class);
    }

    public boolean createSeller(Seller seller) {
        try{
            this.create(seller);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean editSeller(Seller seller) {
        try{
            this.edit(seller);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public void removeSeller(Seller seller) {
        this.remove(seller);
    }

    public List<Seller> getAllSeller() {
        return this.findAll();
    }

    public List<Seller> getRangeSeller(int[] range) {
        return this.findRange(range);
    }

    public Seller getSellerById(String id) {
        return this.find(id);
    }

    public int countSeller() {
        return this.count();
    }

    public Seller getSellerByMemberId(String memberId) {
        TypedQuery<Seller> query = em.createQuery(
                "SELECT s FROM Seller s WHERE s.member.id = :memberId", Seller.class);
        query.setParameter("memberId", memberId);
        query.setHint(QueryHints.REFRESH, HintValues.TRUE);
        List<Seller> sellers = query.getResultList();
        return sellers.isEmpty() ? null : sellers.get(0);
    }

    public boolean isBankAccountExist(String id) {
        Seller seller = getSellerById(id);
        return seller != null && !seller.getBankAccount().equals("");
    }

    public boolean update(String sellerId, String bankAccount, String isApproved){
        Seller seller = getSellerById(sellerId);
        seller.setBankAccount(bankAccount);
        seller.setIsApproved(Integer.parseInt(isApproved));
        return editSeller(seller);
    }

    public boolean updateBankAccount(String sellerId, String bankAccount) {
        Seller seller = getSellerById(sellerId);
        seller.setBankAccount(bankAccount);
        return editSeller(seller);
    }

    public boolean addBalance(String sellerId, double balance){
        Seller seller = getSellerById(sellerId);
        double newBalance = seller.getBalance() + balance;
        seller.setBalance(newBalance);
        return editSeller(seller);
    }

    public boolean minusBalance(String sellerId, double balance){
        Seller seller = getSellerById(sellerId);
        double newBalance = seller.getBalance() - balance;
        seller.setBalance(newBalance);
        return editSeller(seller);
    }

}
