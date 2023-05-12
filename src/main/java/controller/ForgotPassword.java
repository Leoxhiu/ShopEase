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

@WebServlet(name = "ForgotPassword", value = "/guest/s/forgot/password")
public class ForgotPassword extends HttpServlet {

    @EJB
    private MemberFacade memberFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // get form data
        String email = request.getParameter("email");

        String actualCode;

        if(!memberFacade.isExist(email)){
            MessageHandler.setMessage(request, Message.ACCOUNT_NOT_EXIST, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.FORGOT_PASSWORD.getPath());
            return;
        }

        try {
//            actualCode = Email.sendCode(EmailSubject.REGISTRATION, email);
            actualCode = RandomCode.GENERATE();
            System.out.println(actualCode);

        } catch (Exception e) {
            MessageHandler.setMessage(request, Message.EMAIL_NOT_SEND, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.FORGOT_PASSWORD.getPath());
            return;
        }

        HttpSession session = request.getSession();
        session.setAttribute("email", email);
        session.setAttribute("actualCode", actualCode);

        response.sendRedirect(JspPage.CODE_VERIFICATION.getUrl());
    }

}
