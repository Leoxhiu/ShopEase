package controller;

import facade.CustomerOrderFacade;
import facade.OrderCartFacade;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cart;
import model.CustomerOrder;
import model.OrderCart;
import utility.JspPage;
import utility.ServletNavigation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerTransactionDetail", value = "/customer/transaction/detail")
public class CustomerTransactionDetail extends HttpServlet {

    @EJB
    private CustomerOrderFacade customerOrderFacade;

    @EJB
    private OrderCartFacade orderCartFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String customerOrderId = request.getParameter("customerOrderId");
        CustomerOrder customerOrder = customerOrderFacade.getCustomerOrderById(customerOrderId);

        List<OrderCart> orderCartList = orderCartFacade.getAllOrderCartByCustomerOrderId(customerOrderId);

        int totalItem = 0;
        List<Cart> cartList = new ArrayList<>();
        for(OrderCart orderCart : orderCartList){

            Cart cart = orderCart.getCart();
            cartList.add(cart);
            totalItem ++;
        }

        request.setAttribute("totalItem", totalItem);
        request.setAttribute("amount", customerOrder.getAmount());
        request.setAttribute("date", customerOrder.getDate());
        request.setAttribute("cartList", cartList);
        ServletNavigation.forwardRequest(request, response, JspPage.CUSTOMER_TRANSACTION_DETAIL.getPath());
    }
}
