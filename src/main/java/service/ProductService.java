package service;

import facade.ProductFacade;
import facade.SellerFacade;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import model.Product;
import model.Seller;

import java.text.DecimalFormat;

@Stateless(name = "ProductService")
@LocalBean
public class ProductService implements ProductServiceI {

    @EJB
    private SellerFacade sellerFacade;

    @EJB
    private ProductFacade productFacade;


    @Override
    public double findDiscountedPrice(double price, int discount) {
        double discountedPrice = price - (price * discount / 100);

        // Format the discounted price to two decimal places
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String formattedDiscountedPrice = decimalFormat.format(discountedPrice);

        // Parse the formatted string back to double
        discountedPrice = Double.parseDouble(formattedDiscountedPrice);

        return discountedPrice;
    }

    @Override
    public boolean publish(String sellerId, byte[] image, String name, String description, double price, int quantity, String category, int discount) {
        Seller seller = sellerFacade.getSellerById(sellerId);

        double discountedPrice = findDiscountedPrice(price, discount);

        Product product = new Product(seller,image,name,description,price,quantity,category,discount, discountedPrice,0, false);
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
