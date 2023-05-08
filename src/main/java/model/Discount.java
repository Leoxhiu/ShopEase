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
    private String sellerId;
    private String productId;
    private int percentage;
    private String expiryDate;

    public Discount() {
    }

    public Discount(String sellerId, String productId, int percentage, String expiryDate) {
        this.sellerId = sellerId;
        this.productId = productId;
        this.percentage = percentage;
        this.expiryDate = expiryDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
}
