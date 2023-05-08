package utility;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ServletNavigation {
    public static void forwardRequest(HttpServletRequest request, HttpServletResponse response, String pageUrl) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(pageUrl);
        dispatcher.forward(request, response);
    }
}
