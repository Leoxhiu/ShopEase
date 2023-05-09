package controller;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import utility.JspPage;

import java.io.IOException;

public class GuestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession(false);

        // Check if the user is logged in
        if (session != null && session.getAttribute("memberId") != null) {
            // User is already logged in, check user type
            char userType = (char) session.getAttribute("userType");
            if(userType == 'c'){
                // redirect to customer home
                httpResponse.sendRedirect(JspPage.CUSTOMER_HOME.getUrl());
            } else if (userType == 's'){
                // redirect to seller home
                httpResponse.sendRedirect(JspPage.SELLER_HOME.getUrl());
            }
            // admin can access to guest pages (since it is not affecting)

            return;
        }

        chain.doFilter(request, response);
    }
}
