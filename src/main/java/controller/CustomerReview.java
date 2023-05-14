package controller;

import facade.CartFacade;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Cart;
import utility.JspPage;
import utility.ServletNavigation;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerReview", value = "/customer/review")
public class CustomerReview extends HttpServlet {

    @EJB
    private CartFacade cartFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /// get current customer
        HttpSession session = request.getSession();
        String customerId = (String) session.getAttribute("customerId");

        List<Cart> cartList = cartFacade.getPurchasedCartByCustomerId(customerId);

        request.setAttribute("cartList", cartList);
        ServletNavigation.forwardRequest(request, response, JspPage.CUSTOMER_REVIEW.getPath());
    }
}
