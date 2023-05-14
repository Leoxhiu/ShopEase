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
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "SellerSales", value = "/seller/sales")
public class SellerSales extends HttpServlet {

    @EJB
    private CartFacade cartFacade;

    @EJB
    private SellerFacade sellerFacade;

    @EJB
    private ProductFacade productFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /// get current seller
        HttpSession session = request.getSession();
        String sellerId = (String) session.getAttribute("sellerId");
        Seller seller = sellerFacade.getSellerById(sellerId);

        // get seller's product
        List<Product> productList = productFacade.getAllActiveProductBySeller(seller);

        List<Cart> cartList = productList.stream()
                .flatMap(product -> cartFacade.getPurchasedCartByProductId(product.getId()).stream())
                .collect(Collectors.toList());


        request.setAttribute("cartList", cartList);
        ServletNavigation.forwardRequest(request, response, JspPage.SELLER_SALES.getPath());
    }


}
