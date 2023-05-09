package model;

import jakarta.persistence.*;
import org.eclipse.persistence.annotations.UuidGenerator;

@Entity
@UuidGenerator(name = "PRODUCT_ID")
public class Product {

    @Id
    @GeneratedValue(generator = "PRODUCT_ID")
    private String id;
    @OneToOne // A member can be a seller
    @JoinColumn(name = "sellerId", referencedColumnName = "id")
    private Seller seller;
    private int category;
    private byte[] image;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private boolean discount; // got discount or not
    private boolean isDeleted; // is deleted or not

    public Product() {
    }

    public Product(Seller seller, int category, byte[] image, String name, String description, double price, int quantity, boolean discount, boolean isDeleted) {
        this.seller = seller;
        this.category = category;
        this.image = image;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.discount = discount;
        this.isDeleted = isDeleted;
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

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isDiscount() {
        return discount;
    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
