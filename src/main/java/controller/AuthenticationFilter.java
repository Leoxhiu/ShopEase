package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Member;
import utility.JspPage;

import java.io.IOException;

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
        Member member = (Member) session.getAttribute("member");
        String requestedPath = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
        if (requestedPath.startsWith("/customer") && !(member.getUserType() == 'c')) {
            // User is not authorized, redirect to access denied page
            httpResponse.sendRedirect(JspPage.ACCESS_DENIED.getUrl());
            return;
        } else if (requestedPath.startsWith("/seller") && !(member.getUserType() == 's')) {
            // User is not authorized, redirect to access denied page
            httpResponse.sendRedirect(JspPage.ACCESS_DENIED.getUrl());
            return;
        } else if (requestedPath.startsWith("/admin") && !(member.getUserType() == 'a')) {
            // User is not authorized, redirect to access denied page
            httpResponse.sendRedirect(JspPage.ACCESS_DENIED.getUrl());
            return;
        }

        // User is logged in, continue with the request
        chain.doFilter(request, response);
    }
}
