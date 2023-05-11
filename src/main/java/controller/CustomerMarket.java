package controller;

import facade.ProductFacade;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;
import utility.JspPage;
import utility.ServletNavigation;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerMarket", value = {"/customer/market", "/customer/s/market"})
public class CustomerMarket extends HttpServlet {

    @EJB
    private ProductFacade productFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // TODO Generate product list
        List<Product> productList = productFacade.getAllActiveProduct();
        request.setAttribute("productList", productList);
        ServletNavigation.forwardRequest(request, response, JspPage.CUSTOMER_MARKET.getPath());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // TODO Filter product list

    }

}
