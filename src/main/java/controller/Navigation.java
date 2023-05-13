package controller;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import utility.JspPage;

@WebServlet(name = "Navigation", value = "/")
public class Navigation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // Define the mapping of URL paths to JSP pages
        Map<String, String> pathToJspMap = new HashMap<>();

        // Error pages
        pathToJspMap.put(JspPage.PAGE_NOT_FOUND.getUrl(), JspPage.PAGE_NOT_FOUND.getPath());
        pathToJspMap.put(JspPage.ACCESS_DENIED.getUrl(), JspPage.ACCESS_DENIED.getPath());
        pathToJspMap.put(JspPage.SERVER_ERROR.getUrl(), JspPage.SERVER_ERROR.getPath());

        // Guest pages
        pathToJspMap.put(JspPage.INDEX.getUrl(), JspPage.INDEX.getPath());
        pathToJspMap.put(JspPage.LANDING.getUrl(), JspPage.LANDING.getPath());
        pathToJspMap.put(JspPage.SIGN_IN.getUrl(), JspPage.SIGN_IN.getPath());
        pathToJspMap.put(JspPage.CUSTOMER_SIGN_UP.getUrl(), JspPage.CUSTOMER_SIGN_UP.getPath());
        pathToJspMap.put(JspPage.SELLER_SIGN_UP.getUrl(), JspPage.SELLER_SIGN_UP.getPath());
        pathToJspMap.put(JspPage.FORGOT_PASSWORD.getUrl(), JspPage.FORGOT_PASSWORD.getPath());
        pathToJspMap.put(JspPage.CODE_VERIFICATION.getUrl(), JspPage.CODE_VERIFICATION.getPath());
        pathToJspMap.put(JspPage.RESET_PASSWORD.getUrl(), JspPage.RESET_PASSWORD.getPath());

        // Customer pages
        pathToJspMap.put(JspPage.CUSTOMER_HOME.getUrl(), JspPage.CUSTOMER_HOME.getPath());
        pathToJspMap.put(JspPage.CUSTOMER_MARKET.getUrl(), JspPage.CUSTOMER_MARKET.getPath());
        pathToJspMap.put(JspPage.CUSTOMER_PRODUCT_DETAIL.getUrl(), JspPage.CUSTOMER_PRODUCT_DETAIL.getPath());
        pathToJspMap.put(JspPage.CUSTOMER_PROFILE.getUrl(), JspPage.CUSTOMER_PROFILE.getPath());

        // Seller pages
        pathToJspMap.put(JspPage.SELLER_HOME.getUrl(), JspPage.SELLER_HOME.getPath());
        pathToJspMap.put(JspPage.SELLER_MARKET.getUrl(), JspPage.SELLER_MARKET.getPath());
        pathToJspMap.put(JspPage.SELLER_PUBLISH_PRODUCT.getUrl(), JspPage.SELLER_PUBLISH_PRODUCT.getPath());
        pathToJspMap.put(JspPage.SELLER_PRODUCT_DETAIL.getUrl(), JspPage.SELLER_PRODUCT_DETAIL.getPath());
        pathToJspMap.put(JspPage.SELLER_PROFILE.getUrl(), JspPage.SELLER_PROFILE.getPath());

        // Admin pages
        pathToJspMap.put(JspPage.ADMIN_SIGN_IN.getUrl(), JspPage.ADMIN_SIGN_IN.getPath());
        pathToJspMap.put(JspPage.ADMIN_HOME.getUrl(), JspPage.ADMIN_HOME.getPath());
        pathToJspMap.put(JspPage.ADMIN_MEMBER_PAGE.getUrl(), JspPage.ADMIN_MEMBER_PAGE.getPath());
        pathToJspMap.put(JspPage.ADMIN_ADD_ADMIN.getUrl(), JspPage.ADMIN_ADD_ADMIN.getPath());
        pathToJspMap.put(JspPage.ADMIN_ADMIN_PROFILE.getUrl(), JspPage.ADMIN_ADMIN_PROFILE.getPath());
        pathToJspMap.put(JspPage.ADMIN_SELLER_PROFILE.getUrl(), JspPage.ADMIN_SELLER_PROFILE.getPath());
        pathToJspMap.put(JspPage.ADMIN_CUSTOMER_PROFILE.getUrl(), JspPage.ADMIN_CUSTOMER_PROFILE.getPath());
        pathToJspMap.put(JspPage.ADMIN_PROFILE.getUrl(), JspPage.ADMIN_PROFILE.getPath());

        // Get the requested URL path
        String path = request.getRequestURI();

        // Look up the JSP page for the path in the map
        String jspPage = pathToJspMap.get(path);

        // Forward the request to the JSP page
        if (jspPage != null) {
            request.getRequestDispatcher(jspPage).forward(request, response);
        } else if(jspPage == null) {
            // Handle invalid URLs (404 page not found)
            response.sendRedirect(JspPage.PAGE_NOT_FOUND.getUrl());
        }
    }
}
