package service;

import facade.ProductFacade;
import facade.SellerFacade;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import model.Product;
import model.Seller;

@Stateless(name = "ProductService")
@LocalBean
public class ProductService implements ProductServiceI {

    @EJB
    private SellerFacade sellerFacade;

    @EJB
    private ProductFacade productFacade;

    @Override
    public boolean publish(String sellerId, byte[] image, String name, String description, double price, int quantity, String category, int discount) {
        Seller seller = sellerFacade.getSellerById(sellerId);

        Product product = new Product(seller,image,name,description,price,quantity,category,discount,0, false);
        return productFacade.createProduct(product);
    }

    @Override
    public boolean isValidNameLength(String name) {
        int minLength = 2;
        int maxLength = 100;

        return name.length() >= minLength && name.length() <= maxLength;
    }

    @Override
    public boolean isValidDescription(String description) {
        int minLength = 10;

        return description.length() >= minLength;
    }

    @Override
    public boolean isValidPrice(double price) {
        return price > 0 ;
    }

    @Override
    public boolean isValidQuantity(int quantity) {
        return quantity > 0;
    }

    @Override
    public boolean isValidDiscount(int discount) {
        int minDiscount = 0;
        int maxDiscount = 95;

        return discount >= minDiscount && discount <= maxDiscount;
    }
}
