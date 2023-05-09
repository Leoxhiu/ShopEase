package controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utility.JspPage;

import java.io.IOException;

@WebFilter(filterName = "AuthenticationFilter", value = {"/customer/*", "/seller/*", "/admin/*"})
public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);

        if (session == null || session.getAttribute("memberId") == null) {
            // User is not logged in, redirect to sign in page
            httpResponse.sendRedirect(JspPage.ACCESS_DENIED.getUrl());
            return;
        }

        // Check if the user has the required role
        char userType = (char) session.getAttribute("userType");
        String requestedPath = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
        if (requestedPath.startsWith("/customer") && !(userType == 'c')) {
            // User is not authorized, redirect to access denied page
            httpResponse.sendRedirect(JspPage.ACCESS_DENIED.getUrl());
            return;
        } else if (requestedPath.startsWith("/seller") && !(userType == 's')) {
            // User is not authorized, redirect to access denied page
            httpResponse.sendRedirect(JspPage.ACCESS_DENIED.getUrl());
            return;
        } else if (requestedPath.startsWith("/admin") && !(userType == 'a')) {
            // User is not authorized, redirect to access denied page
            httpResponse.sendRedirect(JspPage.ACCESS_DENIED.getUrl());
            return;
        }

        // User is logged in, continue with the request
        chain.doFilter(request, response);
    }
}
