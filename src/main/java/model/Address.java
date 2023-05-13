package model;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.eclipse.persistence.annotations.UuidGenerator;

@Entity
@Cacheable(false)
@UuidGenerator(name = "ADDRESS_ID")
public class Address {
    @Id
    @GeneratedValue(generator = "ADDRESS_ID")
    private String id;
    private String unit;
    private String address;
    private String city;
    private String state;
    private String postal;

    public Address() {
    }

    public Address(String unit, String address, String city, String state, String postal) {
        this.unit = unit;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postal = postal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }
}
