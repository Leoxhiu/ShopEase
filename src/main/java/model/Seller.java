package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.eclipse.persistence.annotations.UuidGenerator;

@Entity
@UuidGenerator(name = "SELLER_ID")
public class Seller {

    @Id
    @GeneratedValue(generator = "SELLER_ID")
    private String id;
    private String addressId;
    private String userId;
    private String image;
    private String bankAccount;
    private double balance;
    private boolean status; // approved or not

    public Seller() {
    }

    public Seller(String addressId, String userId, String image, String bankAccount, double balance, boolean status) {
        this.addressId = addressId;
        this.userId = userId;
        this.image = image;
        this.bankAccount = bankAccount;
        this.balance = balance;
        this.status = status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
