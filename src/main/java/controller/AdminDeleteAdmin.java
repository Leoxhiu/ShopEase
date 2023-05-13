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

@WebServlet(name = "AdminDeleteAdmin", value = "/admin/s/delete/admin")
public class AdminDeleteAdmin extends HttpServlet{

    @EJB
    private MemberFacade memberFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String memberId = request.getParameter("id");

        if(memberFacade.delete(memberId)){
            MessageHandler.setMessage(request, Message.PRODUCT_DELETE_SUCCESS, ButtonText.UNDERSTAND, JspPage.ADMIN_MEMBER_PAGE.getUrl());
            ServletNavigation.forwardRequest(request, response, JspPage.ADMIN_ADMIN_PROFILE.getPath());
        } else {
            MessageHandler.setMessage(request, Message.PRODUCT_DELETE_FAILED, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.ADMIN_ADMIN_PROFILE.getPath());
        }
    }
}
