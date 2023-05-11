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
    List<Product> getAllActiveProduct();
}
