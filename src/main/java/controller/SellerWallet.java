package controller;

import facade.SellerFacade;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Seller;
import utility.*;

import java.io.IOException;

@WebServlet(name = "SellerWallet", value = "/seller/s/wallet")
public class SellerWallet extends HttpServlet {

    @EJB
    private SellerFacade sellerFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();
        String sellerId = (String) session.getAttribute("sellerId");
        double sellerBalance = (double) session.getAttribute("sellerBalance");

        String withDrawAmount = request.getParameter("withDrawAmount");

        if (!(Integer.parseInt(withDrawAmount) > 0) || Integer.parseInt(withDrawAmount) >sellerBalance) {
            MessageHandler.setMessage(request, Message.WITHDRAW_AMOUNT_INVALID, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.SELLER_WALLET.getPath());
            return;
        }

        Seller seller = sellerFacade.getSellerById(sellerId);
        if (sellerFacade.minusBalance(sellerId, Integer.parseInt(withDrawAmount))) {
            double newBalance = sellerBalance - Integer.parseInt(withDrawAmount);
            session.setAttribute("sellerBalance", newBalance);
            MessageHandler.setMessage(request, Message.WITHDRAW_SUCCESS, ButtonText.UNDERSTAND, JspPage.SELLER_WALLET.getUrl());
            ServletNavigation.forwardRequest(request, response, JspPage.SELLER_WALLET.getPath());
            return;
        } else{
            MessageHandler.setMessage(request, Message.WITHDRAW_FAILED, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.SELLER_WALLET.getPath());
        }
    }

}
