package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utility.JspPage;

import java.io.IOException;

public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession(false);

        if (session == null || session.getAttribute("member_id") == null) {
            // User is not logged in, redirect to login page
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendRedirect(JspPage.SIGN_IN.getUrl());
            return;
        }

        // User is logged in, continue with the request
        chain.doFilter(request, response);
    }
}
