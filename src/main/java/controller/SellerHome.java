package controller;


import facade.CartFacade;
import facade.ProductFacade;
import facade.SellerFacade;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Cart;
import model.Product;
import model.Seller;
import utility.JspPage;
import utility.ServletNavigation;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "SellerHome", value = {"/seller/home", "/seller/s/home"})
public class SellerHome extends HttpServlet {

    @EJB
    private SellerFacade sellerFacade;

    @EJB
    private ProductFacade productFacade;

    @EJB
    private CartFacade cartFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // get seller
        HttpSession session = request.getSession();
        String sellerId = (String) session.getAttribute("sellerId");
        Seller seller = sellerFacade.getSellerById(sellerId);

        // PRODUCT DETAILS
        int totalProduct = 0, totalOrder = 0;
        int oneStar = 0, twoStar = 0, threeStar = 0, fourStar = 0, fiveStar = 0;
        double totalSales = 0;
        List<Product> productList = productFacade.getAllActiveProductBySeller(seller);

        for(Product product: productList){
            totalProduct++;
            if(product.getRating() == 1){
                oneStar++;
            }

            if(product.getRating() == 2){
                twoStar++;
            }

            if(product.getRating() == 3){
                threeStar++;
            }

            if(product.getRating() == 4){
                fourStar++;
            }
            if(product.getRating() == 5){
                fiveStar++;
            }

        }

        // get total sales by summing up the price of purchased cart
        List<Cart> cartList = productList.stream()
                .flatMap(product -> cartFacade.getPurchasedCartByProductId(product.getId()).stream())
                .collect(Collectors.toList());

        for(Cart cart : cartList){
            totalOrder++;
            totalSales += cart.getPrice();
        }

        request.setAttribute("oneStar", oneStar);
        request.setAttribute("twoStar", twoStar);
        request.setAttribute("threeStar", threeStar);
        request.setAttribute("fourStar", fourStar);
        request.setAttribute("fiveStar", fiveStar);

        request.setAttribute("totalProduct", totalProduct);
        request.setAttribute("totalOrder", totalOrder);
        request.setAttribute("totalSales", totalSales);

        ServletNavigation.forwardRequest(request, response, JspPage.SELLER_HOME.getPath());
    }
}
