package controller;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "navigation", value = "/")
public class Navigation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String path = request.getRequestURI();

        if (path.equals("/shopease/")) {
            request.getRequestDispatcher("/pages/index.jsp").forward(request, response);
        } else if (path.equals("/shopease/welcome")) {
            request.getRequestDispatcher("/pages/landing.jsp").forward(request, response);
        } else if (path.equals("/shopease/customer/sign-in")) {
            request.getRequestDispatcher("/pages/signIn.jsp").forward(request, response);
        } else if (path.equals("/shopease/customer/sign-up")) {
            request.getRequestDispatcher("/pages/signUp.jsp").forward(request, response);
        } else if (path.equals("/shopease/customer/forgot-password")) {
            request.getRequestDispatcher("/pages/forgotPassword.jsp").forward(request, response);
        } else if (path.equals("/shopease/customer/code/verification")) {
            request.getRequestDispatcher("/pages/codeVerification.jsp").forward(request, response);
        } else if (path.equals("/shopease/customer/reset/password")) {
            request.getRequestDispatcher("/pages/resetPassword.jsp").forward(request, response);
        } else if (path.equals("/shopease/customer/home")) {
            request.getRequestDispatcher("/pages/customerHome.jsp").forward(request, response);
        } else if (path.equals("/shopease/customer/market")) {
            request.getRequestDispatcher("/pages/market.jsp").forward(request, response);
        }
    }
}
