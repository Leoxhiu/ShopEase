package controller;

import facade.ProductFacade;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
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

        String isSearch = request.getParameter("isSearch");
        String isFilter = request.getParameter("isFilter");

        if(isSearch == null && isFilter == null){
            List<Product> productList = productFacade.getAllAvailableProduct();
            request.setAttribute("productList", productList);
            ServletNavigation.forwardRequest(request, response, JspPage.CUSTOMER_MARKET.getPath());
            return;
        }

        if(!(isSearch == null)){
            String searchTerm = request.getParameter("searchTerm");
            List<Product> productList = productFacade.getAllAvailableProductWithSearchTerm(searchTerm);
            request.setAttribute("productList", productList);
            ServletNavigation.forwardRequest(request, response, JspPage.CUSTOMER_MARKET.getPath());
            return;
        }

        if(!(isFilter == null)){
            // Retrieve the selected filters
            String[] selectedCategories = request.getParameterValues("selectedCategories");
            String priceOrder = request.getParameter("priceOrder");
            String[] selectedDiscounts = request.getParameterValues("selectedDiscounts");
            String[] selectedRatings = request.getParameterValues("selectedRatings");

            List<Product> productList = productFacade.getAllAvailableProductByFilter(selectedCategories, priceOrder, selectedDiscounts, selectedRatings);
            request.setAttribute("productList", productList);
            ServletNavigation.forwardRequest(request, response, JspPage.CUSTOMER_MARKET.getPath());
            return;
        }
    }
}
