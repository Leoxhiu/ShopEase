package controller;

import facade.*;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.*;
import utility.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet(name = "CustomerCart", value = {"/customer/cart", "/customer/s/cart"})
public class CustomerCart extends HttpServlet {

    @EJB
    private CustomerFacade customerFacade;

    @EJB
    private SellerFacade sellerFacade;

    @EJB
    private CartFacade cartFacade;

    @EJB
    private ProductFacade productFacade;

    @EJB
    private AddressFacade addressFacade;

    @EJB
    private CustomerOrderFacade customerOrderFacade;

    @EJB
    private OrderCartFacade orderCartFacade;

    @EJB
    private ReviewFacade reviewFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String customerId = (String) session.getAttribute("customerId");
        List<Cart> cartList = cartFacade.getActiveCartByCustomerId(customerId);
        request.setAttribute("cartList", cartList);

        ServletNavigation.forwardRequest(request,response,JspPage.CUSTOMER_CART.getPath());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] selectedCarts = request.getParameterValues("selectedCarts");

        // get customer profile
        HttpSession session = request.getSession();
        String customerId = (String) session.getAttribute("customerId");
        int cartTotal = (int) session.getAttribute("cartTotal");
        double customerBalance = (double) session.getAttribute("customerBalance");
        Customer customer = customerFacade.getCustomerById(customerId);

        // perform address validation
        if (!addressFacade.isFilled(customer.getAddress().getId())) {
            MessageHandler.setCustomLinkErrorMessage(request, Message.ADDRESS_BLANK.getMessage(), ButtonText.UNDERSTAND, JspPage.CUSTOMER_CART.getUrl());
            ServletNavigation.forwardRequest(request, response, JspPage.CUSTOMER_CART.getPath());
            return;
        }

        if (selectedCarts != null) {
            double totalPrice = 0;
            // validate if product quantity can cover desired quantity
            // get the total carts price
            for (String cartId : selectedCarts) {

                Cart cart = cartFacade.getCartById(cartId);
                Product product = productFacade.getProductById(cart.getProduct().getId());
                if(cart.getQuantity() > product.getQuantity()){
                    MessageHandler.setCustomLinkErrorMessage(request,
                            "Quantity of " + product.getName() + " is not sufficient to support your needs."
                            , ButtonText.UNDERSTAND, JspPage.CUSTOMER_CART.getUrl());
                    ServletNavigation.forwardRequest(request, response, JspPage.CUSTOMER_CART.getPath());
                    return;
                }

                totalPrice += cart.getPrice();
            }

            if(customerBalance < totalPrice){
                MessageHandler.setCustomLinkErrorMessage(request, Message.ACCOUNT_NOT_ENOUGH_BALANCE.getMessage(),
                        ButtonText.UNDERSTAND, JspPage.CUSTOMER_CART.getUrl());
                ServletNavigation.forwardRequest(request, response, JspPage.CUSTOMER_CART.getPath());
                return;
            }

            LocalDateTime currentDateTime = LocalDateTime.now();
            CustomerOrder customerOrder = new CustomerOrder(customer, totalPrice, currentDateTime);
            customerOrderFacade.createCustomerOrder(customerOrder);

            // minus balance of customer
            customerFacade.minusBalance(customerId, totalPrice);

            for (String cartId : selectedCarts) {

                Cart cart = cartFacade.getCartById(cartId);
                Product product = productFacade.getProductById(cart.getProduct().getId());
                Seller seller = sellerFacade.getSellerById(product.getSeller().getId());
                // update cart to purchased
                cartFacade.checkOut(cartId);

                // minus total product quantity
                productFacade.minusQuantity(product.getId(), cart.getQuantity());

                // add balance to seller
                sellerFacade.addBalance(seller.getId(), cart.getPrice());

                // add cart to the main order
                OrderCart orderCart = new OrderCart(cart, customerOrder);
                orderCartFacade.createOrderCart(orderCart);

                // add main review for each cart
                Review review = new Review(cart, 0, "");
                reviewFacade.createReview(review);

                cartTotal--;
            }

            session.setAttribute("cartTotal", cartTotal);
            MessageHandler.setMessage(request, Message.CART_CHECK_OUT_SUCCESS, ButtonText.UNDERSTAND, JspPage.CUSTOMER_CART.getUrl());
            ServletNavigation.forwardRequest(request, response, JspPage.CUSTOMER_CART.getPath());

        } else {
            MessageHandler.setMessage(request, Message.CART_CHECK_OUT_FAILED, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.CUSTOMER_CART.getPath());
            return;
        }
    }
}
