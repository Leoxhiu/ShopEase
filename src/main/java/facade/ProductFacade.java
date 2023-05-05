package facade;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import model.Product;

import java.util.List;

@Stateless (name = "ProductFacade")
@LocalBean
public class ProductFacade extends AbstractFacade<Product> implements ProductFacadeI {
    public ProductFacade() {
        super(Product.class);
    }

    @Override
    public boolean createProduct(Product product) {
        try{
            this.create(product);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean editProduct(Product product) {
        try{
            this.edit(product);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public void removeProduct(Product product) {
        this.remove(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return this.findAll();
    }

    @Override
    public List<Product> getRangeProduct(int[] range) {
        return this.findRange(range);
    }

    @Override
    public Product getProductById(String id) {
        return this.find(id);
    }

    @Override
    public int countProduct() {
        return this.count();
    }
}
