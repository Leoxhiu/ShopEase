package service;

import facade.ProductFacade;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import model.Product;

@Stateless(name = "ProductService")
@LocalBean
public class ProductService implements ProductServiceI {

    @EJB
    private ProductFacade productFacade;

    @Override
    public void create(Product product) {
        productFacade.createProduct(product);
    }
}
