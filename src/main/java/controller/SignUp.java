package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utility.*;

import java.io.*;

@WebServlet(name = "sign/up", value = "/guest/s/sign/up")
public class SignUp extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // get form data
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
        String userType = request.getParameter("account");

        String actualCode;

        // perform validation checks on the form data
        if(password.length() < 8) {
            MessageHandler.setMessage(request, Message.PASSWORD_LENGTH_ERROR, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.SIGN_UP.getPath());
            return;
        }

        if (!confirmPassword.equals(password)) {
            MessageHandler.setMessage(request, Message.PASSWORD_NOT_MATCH, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.SIGN_UP.getPath());
            return;
        }

        try {
//            actualCode = Email.sendCode(EmailSubject.REGISTRATION, email);
            actualCode = RandomCode.GENERATE();
            System.out.println(actualCode);

        } catch (Exception e) {
            MessageHandler.setMessage(request, Message.EMAIL_NOT_SEND, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.SIGN_UP.getPath());
            return;
        }

        HttpSession session = request.getSession();

        session.setAttribute("email", email);
        session.setAttribute("password", password);
        session.setAttribute("userType", userType);
        session.setAttribute("actualCode", actualCode);

        response.sendRedirect(JspPage.CODE_VERIFICATION.getUrl());

    }
}