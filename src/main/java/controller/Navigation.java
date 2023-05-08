package controller;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import utility.JspPage;

@WebServlet(name = "navigation", value = "/")
public class Navigation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // Define the mapping of URL paths to JSP pages
        Map<String, String> pathToJspMap = new HashMap<>();
        pathToJspMap.put("/shopease/", JspPage.INDEX.getUrl());
        pathToJspMap.put("/shopease/welcome", JspPage.LANDING.getUrl());
        pathToJspMap.put("/shopease/sign-in", JspPage.SIGN_IN.getUrl());
        pathToJspMap.put("/shopease/sign-up", JspPage.SIGN_UP.getUrl());
        pathToJspMap.put("/shopease/forgot-password", JspPage.FORGOT_PASSWORD.getUrl());
        pathToJspMap.put("/shopease/code-verification", JspPage.CODE_VERIFICATION.getUrl());
        pathToJspMap.put("/shopease/reset-password", JspPage.RESET_PASSWORD.getUrl());
        pathToJspMap.put("/shopease/customer/home", JspPage.HOME.getUrl());
        pathToJspMap.put("/shopease/customer/market", JspPage.MARKET.getUrl());

        // Get the requested URL path
        String path = request.getRequestURI();

        // Look up the JSP page for the path in the map
        String jspPage = pathToJspMap.get(path);

        // Forward the request to the JSP page
        if (jspPage != null) {
            request.getRequestDispatcher(jspPage).forward(request, response);
        } else {
            // Handle invalid URLs (404 page not found)
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
