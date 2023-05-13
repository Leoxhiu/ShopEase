package controller;

import facade.CartFacade;
import facade.CustomerFacade;
import facade.ProductFacade;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Cart;
import model.Customer;
import model.Product;
import utility.*;

import java.io.IOException;

@WebServlet(name = "CustomerProductDetail", value = {"/customer/product/detail", "/customer/s/product/detail"})
public class CustomerProductDetail extends HttpServlet {

    @EJB
    private ProductFacade productFacade;

    @EJB
    private CustomerFacade customerFacade;

    @EJB
    private CartFacade cartFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String productId = request.getParameter("productId");
        Product product = productFacade.getProductById(productId);

        request.setAttribute("productId", product.getId());
        request.setAttribute("productName", product.getName());
        request.setAttribute("productDescription", product.getDescription());
        request.setAttribute("productPrice", product.getPrice());
        request.setAttribute("productQuantity", product.getQuantity());
        request.setAttribute("productCategory", ProductCategoryHandler.getCategoryName(product.getCategory()));
        request.setAttribute("productDiscount", product.getDiscount());
        request.setAttribute("productDiscountedPrice", product.getDiscountedPrice());
        request.setAttribute("productRating", product.getRating());

        ServletNavigation.forwardRequest(request, response, JspPage.CUSTOMER_PRODUCT_DETAIL.getPath());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String productId = request.getParameter("productId");
        String desiredQuantity = request.getParameter("quantity");

        // Get the product
        Product product = productFacade.getProductById(productId);

        request.setAttribute("productId", product.getId());
        request.setAttribute("productName", product.getName());
        request.setAttribute("productDescription", product.getDescription());
        request.setAttribute("productPrice", product.getPrice());
        request.setAttribute("productQuantity", product.getQuantity());
        request.setAttribute("productCategory", ProductCategoryHandler.getCategoryName(product.getCategory()));
        request.setAttribute("productDiscount", product.getDiscount());
        request.setAttribute("productDiscountedPrice", product.getDiscountedPrice());
        request.setAttribute("productRating", product.getRating());

        if (!productFacade.isValidQuantity(Integer.parseInt(desiredQuantity))) {
            MessageHandler.setMessage(request, Message.PRODUCT_QUANTITY_INVALID, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.CUSTOMER_PRODUCT_DETAIL.getPath());
            return;
        }

        // Get customer and his cart
        HttpSession session = request.getSession();
        String customerId = (String) session.getAttribute("customerId");
        Customer customer = customerFacade.getCustomerById(customerId);

        int cartTotal = (int) session.getAttribute("cartTotal");
        double totalPrice = product.getDiscountedPrice() * Integer.parseInt(desiredQuantity);

        // add to cart
        Cart cart = new Cart(customer, product, Integer.parseInt(desiredQuantity), totalPrice, 0);

        if(cartFacade.createCart(cart)){
            cartTotal++;
            session.setAttribute("cartTotal", cartTotal);
            MessageHandler.setMessage(request, Message.CART_ADD_SUCCESS, ButtonText.UNDERSTAND, JspPage.CUSTOMER_CART.getUrl());
            ServletNavigation.forwardRequest(request, response, JspPage.CUSTOMER_PRODUCT_DETAIL.getPath());
        } else {
            MessageHandler.setMessage(request, Message.PRODUCT_NOT_ENOUGH, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.CUSTOMER_PRODUCT_DETAIL.getPath());
        }
    }
}
