package model;

import jakarta.persistence.*;
import org.eclipse.persistence.annotations.UuidGenerator;

@Entity
@UuidGenerator(name = "CUSTOMER_ID")
public class Customer{
    @Id
    @GeneratedValue(generator = "CUSTOMER_ID")
    private String id;
    @OneToOne // A member can be a customer
    @JoinColumn(name = "memberId", referencedColumnName = "id")
    private Member member;
    @OneToOne // A customer can only have an address
    @JoinColumn(name = "addressId", referencedColumnName = "id")
    private Address address;

    private double balance;

    public Customer() {

    }

    public Customer(Member member, Address address, double balance) {
        this.member = member;
        this.address = address;
        this.balance = balance;
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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
