package controller;

import facade.CustomerOrderFacade;
import facade.OrderCartFacade;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.CustomerOrder;
import model.OrderCart;
import utility.JspPage;
import utility.ServletNavigation;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerTransaction", value = "/customer/transaction")
public class CustomerTransaction extends HttpServlet {

    @EJB
    private CustomerOrderFacade customerOrderFacade;

    @EJB
    private OrderCartFacade orderCartFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // get the customer
        HttpSession session = request.getSession();
        String customerId = (String) session.getAttribute("customerId");

        List<CustomerOrder> customerOrderList = customerOrderFacade.getAllCustomerOrderByCustomerIdDESC(customerId);
        List<OrderCart> orderCartList = orderCartFacade.getAllOrderCart();

        request.setAttribute("customerOrderList", customerOrderList);
        request.setAttribute("orderCartList", orderCartList);

        ServletNavigation.forwardRequest(request,response, JspPage.CUSTOMER_TRANSACTION.getPath());
    }
}
