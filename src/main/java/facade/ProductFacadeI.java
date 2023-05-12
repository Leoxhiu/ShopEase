package facade;

import jakarta.ejb.Local;
import model.Product;

import java.util.List;

@Local
public interface ProductFacadeI {

    boolean createProduct(Product product);
    boolean editProduct(Product product);
    void removeProduct(Product product);
    List<Product> getAllProduct();
    List<Product> getRangeProduct(int[] range);
    Product getProductById(String id);
    int countProduct();
    List<Product> getAllActiveProduct(); // not deleted
    List<Product> getAllActiveProductBySellerId(String sellerId);
    List<Product> getAllActiveProductBySellerIdANDSearchTerm(String sellerId, String searchTerm);
    List<Product> getAllActiveProductBySellerIdANDFilter(String sellerId, String[] selectedCategories, String priceOrder, String[] selectedDiscounts, String[] selectedRatings);

    List<Product> getAllAvailableProduct(); // not deleted and >0
    List<Product> getAllAvailableProductWithSearchTerm(String searchTerm);
    List<Product> getAllAvailableProductByFilter(String[] selectedCategories, String priceOrder, String[] selectedDiscounts, String[] selectedRatings);

}
