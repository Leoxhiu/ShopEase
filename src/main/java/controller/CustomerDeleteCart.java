package controller;


import facade.CartFacade;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utility.*;

import java.io.IOException;

@WebServlet(name = "CustomerDeleteCart", value = "/customer/delete/cart")
public class CustomerDeleteCart extends HttpServlet {

    @EJB
    private CartFacade cartFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cartId = request.getParameter("cartId");

        if(cartFacade.delete(cartId)){
            MessageHandler.setMessage(request, Message.CART_DELETE_SUCCESS, ButtonText.UNDERSTAND, JspPage.CUSTOMER_CART.getUrl());
            ServletNavigation.forwardRequest(request, response, JspPage.CUSTOMER_CART.getPath());
        } else {
            MessageHandler.setMessage(request, Message.CART_DELETE_FAILED, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.CUSTOMER_CART.getPath());
        }

    }
}
