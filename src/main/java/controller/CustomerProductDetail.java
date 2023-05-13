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
import utility.ProductCategory;
import utility.ProductCategoryHandler;
import utility.ServletNavigation;

import java.io.IOException;

@WebServlet(name = "CustomerProductDetail", value = {"/customer/product/detail", "/customer/s/product/detail"})
public class CustomerProductDetail extends HttpServlet {

    @EJB
    private ProductFacade productFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String productId = request.getParameter("productId");
        Product product = productFacade.getProductById(productId);

        request.setAttribute("productId", product.getId());
        request.setAttribute("productName", product.getName());
        request.setAttribute("productDescription", product.getDescription());
        request.setAttribute("productPrice", product.getPrice());
        request.setAttribute("productQuantity", product.getQuantity());
        request.setAttribute("productCategory", ProductCategoryHandler.getCategoryName(product.getCategory()));
        request.setAttribute("productDiscount", product.getDiscount());
        request.setAttribute("productDiscountedPrice", product.getDiscountedPrice());
        request.setAttribute("productRating", product.getRating());

        System.out.println(productId);

        ServletNavigation.forwardRequest(request, response, JspPage.CUSTOMER_PRODUCT_DETAIL.getPath());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String productId = request.getParameter("productId");
        String desiredQuantity = request.getParameter("quantity");

        Product product = productFacade.getProductById(productId);




        // Get customer and his cart
        HttpSession session = request.getSession();
        String customerId = (String) session.getAttribute("customerId");
        int cartTotal = (int) session.getAttribute("cartTotal");

        //TODO add to cart

        // Add session cart +1
        // Validate 0 quantity
        // validate if desired quantity > total quantity

        // calculate total price

        // success modal -> cart page
        // error modal -> this
    }
}
