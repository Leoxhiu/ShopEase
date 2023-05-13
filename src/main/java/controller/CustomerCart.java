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

@WebServlet(name = "CustomerCart", value = {"/customer/cart", "/customer/s/cart"})
public class CustomerCart extends HttpServlet {

    @EJB
    private CartFacade cartFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String customerId = (String) session.getAttribute("customerId");
        List<Cart> cartList = cartFacade.getActiveCartByCustomerId(customerId);
        request.setAttribute("cartList", cartList);

        ServletNavigation.forwardRequest(request,response,JspPage.CUSTOMER_CART.getPath());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] selectedCarts = request.getParameterValues("selectedCarts");
        if (selectedCarts != null) {
            for (String cart : selectedCarts) {
                System.out.println(cart);
            }
        }
    }
}
