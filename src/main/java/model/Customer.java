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
    private String member_id;
    private String address_id;
    private String image;

    private double balance;

    public Customer() {

    }

    public Customer(String member_id, String image, String address_id, double balance) {
        this.member_id = member_id;
        this.image = image;
        this.address_id = address_id;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAddress_id() {
        return address_id;
    }

    public void setAddress_id(String address_id) {
        this.address_id = address_id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
