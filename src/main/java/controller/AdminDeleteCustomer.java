package controller;

import facade.MemberFacade;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utility.*;

import java.io.IOException;

@WebServlet(name = "AdminDeleteCustomer", value = "/admin/s/delete/customer")
public class AdminDeleteCustomer extends HttpServlet {

    @EJB
    private MemberFacade memberFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String memberId = request.getParameter("id");

        if(memberFacade.delete(memberId)){
            MessageHandler.setMessage(request, Message.ACCOUNT_DELETED_SUCCESS, ButtonText.UNDERSTAND, JspPage.ADMIN_MEMBER_PAGE.getUrl());
            ServletNavigation.forwardRequest(request, response, JspPage.ADMIN_CUSTOMER_PROFILE.getPath());
        } else {
            MessageHandler.setMessage(request, Message.ACCOUNT_DELETED_FAILED, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.ADMIN_CUSTOMER_PROFILE.getPath());
        }
    }
}
