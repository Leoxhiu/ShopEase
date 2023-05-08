package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Member;
import utility.JspPage;

import java.io.IOException;

public class GuestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Check if the user is logged in
        HttpSession session = httpRequest.getSession(false);
        if (session != null && session.getAttribute("member") != null) {
            // User is already logged in, check user type
            Member member = (Member) session.getAttribute("member");
            if(member.getUserType() == 'c'){
                // redirect to customer home
                httpResponse.sendRedirect(httpRequest.getContextPath() + JspPage.CUSTOMER_HOME.getUrl());
            } else if (member.getUserType() == 's'){
                // redirect to seller home
                httpResponse.sendRedirect(httpRequest.getContextPath() + JspPage.SELLER_HOME.getUrl());
            } else if (member.getUserType() == 'a'){
                // redirect to admin home
                httpResponse.sendRedirect(httpRequest.getContextPath() + JspPage.ADMIN_HOME.getUrl());
            }
            return;
        }

        chain.doFilter(request, response);
    }
}
