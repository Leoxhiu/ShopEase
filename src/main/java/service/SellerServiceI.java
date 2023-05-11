package service;

import jakarta.ejb.Local;
import model.Member;

@Local
public interface SellerServiceI {

    boolean isBankAccountExist(String id);
    boolean isAddressExists(String id);
    boolean signUp(Member member);
    boolean updateBankAccount(String sellerId, String bankAccount);
}
