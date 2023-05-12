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
    private String bankAccount;
    private double balance;
    private int isApproved; // approved or not

    public Seller() {
    }

    public Seller(Member member, Address address, String bankAccount, double balance, int isApproved) {
        this.member = member;
        this.address = address;
        this.bankAccount = bankAccount;
        this.balance = balance;
        this.isApproved = isApproved;
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

    public int getIsApproved() {
        return isApproved;
    }

    public void setIsApproved(int isApproved) {
        this.isApproved = isApproved;
    }
}
