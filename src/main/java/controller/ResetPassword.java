package controller;

import facade.MemberFacade;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utility.*;

import java.io.IOException;

@WebServlet(name = "ResetPassword", value = "/guest/s/reset/password")
public class ResetPassword extends HttpServlet {

    @EJB
    private MemberFacade memberFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // get form data
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");

        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");

        if(!memberFacade.isValidPasswordLength(password)) {
            MessageHandler.setMessage(request, Message.PASSWORD_LENGTH_INVALID, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.RESET_PASSWORD.getPath());
            return;
        }

        if (!confirmPassword.equals(password)) {
            MessageHandler.setMessage(request, Message.PASSWORD_NOT_MATCH, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.RESET_PASSWORD.getPath());
            return;
        }

        if(memberFacade.updatePassword(email, password)){
            MessageHandler.setMessage(request, Message.RESET_PASSWORD_SUCCESS, ButtonText.LOGIN_NOW, JspPage.SIGN_IN.getUrl());
            ServletNavigation.forwardRequest(request, response, JspPage.RESET_PASSWORD.getPath());
        } else {
            MessageHandler.setMessage(request, Message.RESET_PASSWORD_FAILED, ButtonText.UNDERSTAND, "");
            response.sendRedirect(JspPage.FORGOT_PASSWORD.getUrl());
        }

    }

}
