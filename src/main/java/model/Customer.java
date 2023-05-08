package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.eclipse.persistence.annotations.UuidGenerator;

@Entity
@UuidGenerator(name = "CUSTOMER_ID")
public class Customer{
    @Id
    @GeneratedValue(generator = "CUSTOMER_ID")
    private String id;
    private String memberId;
    private String addressId;

    private double balance;

    public Customer() {

    }

    public Customer(String memberId, String addressId, double balance) {
        this.memberId = memberId;
        this.addressId = addressId;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
