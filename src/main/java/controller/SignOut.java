package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utility.JspPage;

import java.io.IOException;

@WebServlet(name = "SignOut", value = "/s/sign/out")
public class SignOut extends HttpServlet {

    //TODO Perform Sign out for users
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();
        char userType = (char) session.getAttribute("userType");

        session.invalidate();

        if(userType == 'a'){
            response.sendRedirect(JspPage.ADMIN_SIGN_IN.getUrl());
            return;
        }

        response.sendRedirect(JspPage.LANDING.getUrl());

    }

}
