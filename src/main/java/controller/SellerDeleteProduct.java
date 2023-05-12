package controller;


import facade.ProductFacade;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utility.*;

import java.io.IOException;

@WebServlet(name = "SellerDeleteProduct", value = "/seller/s/delete/product")
public class SellerDeleteProduct extends HttpServlet {

    @EJB
    private ProductFacade productFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String productId = request.getParameter("productId");

        if(productFacade.delete(productId)){
            MessageHandler.setMessage(request, Message.PRODUCT_DELETE_SUCCESS, ButtonText.UNDERSTAND, JspPage.SELLER_MARKET.getUrl());
            ServletNavigation.forwardRequest(request, response, JspPage.SELLER_PRODUCT_DETAIL.getPath());
        } else {
            MessageHandler.setMessage(request, Message.PRODUCT_DELETE_FAILED, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.SELLER_PRODUCT_DETAIL.getPath());
        }
    }
}
