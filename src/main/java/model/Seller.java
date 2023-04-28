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
    private String address_id;
    private String user_id;
    private String image;
    private String bank_account;
    private double balance;
    private boolean status; // approved or not

    public Seller() {
    }

    public Seller(String address_id, String user_id, String image, String bank_account, double balance, boolean status) {
        this.address_id = address_id;
        this.user_id = user_id;
        this.image = image;
        this.bank_account = bank_account;
        this.balance = balance;
        this.status = status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getAddress_id() {
        return address_id;
    }

    public void setAddress_id(String address_id) {
        this.address_id = address_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBank_account() {
        return bank_account;
    }

    public void setBank_account(String bank_account) {
        this.bank_account = bank_account;
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
