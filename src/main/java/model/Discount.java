package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.eclipse.persistence.annotations.UuidGenerator;

@Entity
@UuidGenerator(name = "DISCOUNT_ID")
public class Discount {
    @Id
    @GeneratedValue(generator = "DISCOUNT_ID")
    private String id;
    private String seller_id;
    private String product_id;
    private int percentage;
    private String expiry_date;

    public Discount() {
    }

    public Discount(String seller_id, String product_id, int percentage, String expiry_date) {
        this.seller_id = seller_id;
        this.product_id = product_id;
        this.percentage = percentage;
        this.expiry_date = expiry_date;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public String getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(String expiry_date) {
        this.expiry_date = expiry_date;
    }
}
