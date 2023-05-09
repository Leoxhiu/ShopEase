package model;

import jakarta.persistence.*;
import org.eclipse.persistence.annotations.UuidGenerator;

@Entity
@UuidGenerator(name = "SELLER_ID")
public class Seller {

    @Id
    @GeneratedValue(generator = "SELLER_ID")
    private String id;
    @OneToOne // A member can be a seller
    @JoinColumn(name = "memberId", referencedColumnName = "id")
    private Member member;
    @OneToOne // A seller can have an address
    @JoinColumn(name = "addressId", referencedColumnName = "id")
    private Address address;
    private String image;
    private String bankAccount;
    private double balance;
    private boolean status; // approved or not

    public Seller() {
    }

    public Seller(Member member, Address address, String image, String bankAccount, double balance, boolean status) {
        this.member = member;
        this.address = address;
        this.image = image;
        this.bankAccount = bankAccount;
        this.balance = balance;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
