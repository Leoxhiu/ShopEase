package controller;

import facade.CustomerFacade;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Customer;
import utility.*;

import java.io.IOException;

@WebServlet(name = "CustomerWallet", value = "/customer/s/wallet")
public class CustomerWallet extends HttpServlet {

    @EJB
    private CustomerFacade customerFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();
        String customerId = (String) session.getAttribute("customerId");
        double customerBalance = (double) session.getAttribute("customerBalance");

        String bankAccount = request.getParameter("bankAccount");
        String reloadAmount = request.getParameter("reloadAmount");

        if (!BankAccountValidator.isValidBankAccount(bankAccount)) {
            MessageHandler.setMessage(request, Message.BANK_ACCOUNT_INVALID, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.CUSTOMER_WALLET.getPath());
            return;
        }

        if (!(Integer.parseInt(reloadAmount) > 0)) {
            MessageHandler.setMessage(request, Message.RELOAD_AMOUNT_INVALID, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.CUSTOMER_WALLET.getPath());
            return;
        }

        Customer customer = customerFacade.getCustomerById(customerId);
        if (customerFacade.addBalance(customerId, Integer.parseInt(reloadAmount))) {
            double newBalance = customerBalance + Integer.parseInt(reloadAmount);
            session.setAttribute("customerBalance", newBalance);
            MessageHandler.setMessage(request, Message.RELOAD_SUCCESS, ButtonText.UNDERSTAND, JspPage.CUSTOMER_WALLET.getUrl());
            ServletNavigation.forwardRequest(request, response, JspPage.CUSTOMER_WALLET.getPath());
            return;
        } else{
            MessageHandler.setMessage(request, Message.RELOAD_FAILED, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.CUSTOMER_WALLET.getPath());
        }
    }
}
