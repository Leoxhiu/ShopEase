package controller;

import facade.*;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Customer;
import model.Member;
import model.Seller;
import utility.*;

import java.io.IOException;

@WebServlet(name = "SignIn", value = "/guest/s/sign/in")
public class SignIn extends HttpServlet {

    @EJB
    private MemberFacade memberFacade;

    @EJB
    private CustomerFacade customerFacade;

    @EJB
    private AddressFacade addressFacade;

    @EJB
    private CartFacade cartFacade;

    @EJB
    private SellerFacade sellerFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // get form data
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (!memberFacade.isExist(email)) {
            MessageHandler.setMessage(request, Message.ACCOUNT_NOT_EXIST, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.SIGN_IN.getPath());
            return;
        }

        Member member = memberFacade.getMemberByEmail(email);
        if (member.getIsDeleted() == 1) {
            MessageHandler.setMessage(request, Message.ACCOUNT_NOT_EXIST, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.SIGN_IN.getPath());
            return;
        }

        if (!password.equals(member.getPassword())) {
            MessageHandler.setMessage(request, Message.SIGN_IN_FAILED, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.SIGN_IN.getPath());
            return;
        }

        HttpSession session = request.getSession();
        // member details
        session.setAttribute("memberId", member.getId());
        session.setAttribute("memberName", member.getName());
        session.setAttribute("memberEmail", member.getEmail());
        session.setAttribute("userType", member.getUserType());

        if(!CookieUtils.cookieExists(request, "isUser")){
            CookieUtils.addCookie(response, "isUser", "true", -1, "/");
        }

        if (member.getUserType().equals("c")) {
            // customer details
            Customer customer = customerFacade.getCustomerByMemberId(member.getId());
            session.setAttribute("customerId", customer.getId());        // get customerId from database
            session.setAttribute("customerBalance", customer.getBalance()); // get customerBalance from database
            // address details
            session.setAttribute("addressId", customer.getAddress().getId());   // get addressId from database
            // cart details
            int cartTotal = cartFacade.countActiveCartByCustomerId(customer.getId());
            session.setAttribute("cartTotal", cartTotal);         // get cartTotal from database

            response.sendRedirect(JspPage.CUSTOMER_HOME.getUrl());

        } else if (member.getUserType().equals("s")){
            // seller details
            Seller seller = sellerFacade.getSellerByMemberId(member.getId());
            // check if seller is approved
            if (!(seller.getIsApproved() == 1)) {
                session.invalidate();
                MessageHandler.setMessage(request, Message.ACCOUNT_NOT_APPROVED, ButtonText.UNDERSTAND, "");
                ServletNavigation.forwardRequest(request, response, JspPage.SIGN_IN.getPath());
                return;
            }
            session.setAttribute("sellerId", seller.getId());        // get sellerId from database
            // address details
            session.setAttribute("addressId", seller.getAddress().getId());   // get addressId from database
            session.setAttribute("sellerBalance", seller.getBalance());
            response.sendRedirect(JspPage.SELLER_HOME.getUrl());
        } else if (member.getUserType() == "a") {
            session.invalidate();
            response.sendRedirect(JspPage.ACCESS_DENIED.getUrl());
        }
    }
}
