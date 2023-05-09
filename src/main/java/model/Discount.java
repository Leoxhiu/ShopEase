package model;

import jakarta.persistence.*;
import org.eclipse.persistence.annotations.UuidGenerator;

@Entity
@UuidGenerator(name = "DISCOUNT_ID")
public class Discount {
    @Id
    @GeneratedValue(generator = "DISCOUNT_ID")
    private String id;
    @ManyToOne // A seller can give many discount
    @JoinColumn(name = "sellerId", referencedColumnName = "id")
    private Seller seller;
    @OneToOne // A discount only for a product
    @JoinColumn(name = "productId", referencedColumnName = "id")
    private Product product;
    private int percentage;
    private String expiryDate;

    public Discount() {
    }

    public Discount(Seller seller, Product product, int percentage, String expiryDate) {
        this.seller = seller;
        this.product = product;
        this.percentage = percentage;
        this.expiryDate = expiryDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
