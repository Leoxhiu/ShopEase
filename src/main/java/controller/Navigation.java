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
        pathToJspMap.put(JspPage.INDEX.getUrl(), JspPage.INDEX.getPath());
        pathToJspMap.put(JspPage.LANDING.getUrl(), JspPage.LANDING.getPath());
        pathToJspMap.put(JspPage.SIGN_IN.getUrl(), JspPage.SIGN_IN.getPath());
        pathToJspMap.put(JspPage.SIGN_UP.getUrl(), JspPage.SIGN_UP.getPath());
        pathToJspMap.put(JspPage.FORGOT_PASSWORD.getUrl(), JspPage.FORGOT_PASSWORD.getPath());
        pathToJspMap.put(JspPage.CODE_VERIFICATION.getUrl(), JspPage.CODE_VERIFICATION.getPath());
        pathToJspMap.put(JspPage.RESET_PASSWORD.getUrl(), JspPage.RESET_PASSWORD.getPath());
        pathToJspMap.put(JspPage.HOME.getUrl(), JspPage.HOME.getPath());
        pathToJspMap.put(JspPage.MARKET.getUrl(), JspPage.MARKET.getPath());

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
