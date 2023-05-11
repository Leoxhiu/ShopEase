package service;

import jakarta.ejb.Local;
import model.Product;

@Local
public interface ProductServiceI {

    boolean publish(String sellerId, byte[] image, String name, String description, double price, int quantity, String category, int discount);
    boolean isValidNameLength(String name);
    boolean isValidDescription(String description);
    boolean isValidPrice(double price);
    boolean isValidQuantity(int quantity);
    boolean isValidDiscount(int discount);
}
