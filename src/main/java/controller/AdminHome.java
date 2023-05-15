package controller;

import facade.CustomerOrderFacade;
import facade.MemberFacade;
import facade.ProductFacade;
import facade.ReviewFacade;
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

@WebServlet(name = "AdminHome", value = {"/admin/home", "/admin/s/home"})
public class AdminHome extends HttpServlet {

    @EJB
    private MemberFacade memberFacade;

    @EJB
    private ProductFacade productFacade;

    @EJB
    private CustomerOrderFacade customerOrderFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int totalUser, totalCustomer, totalSeller;

        // USER RELATED
        totalUser = memberFacade.countMember();
        totalCustomer = (int) memberFacade.getCustomerCount();
        totalSeller = (int) memberFacade.getSellerCount();


        // PRODUCT RELATED
        int totalProduct, oneStar, twoStar, threeStar, fourStar, fiveStar;
        totalProduct = productFacade.countProduct();
        oneStar = productFacade.countProductsByRating(1);
        twoStar = productFacade.countProductsByRating(2);
        threeStar = productFacade.countProductsByRating(3);
        fourStar = productFacade.countProductsByRating(4);
        fiveStar = productFacade.countProductsByRating(5);

        List<Product> topRatedProducts = productFacade.getTopRatedProducts(3);

        // ORDER RELATED
        int totalOrder;
        double totalSales;
        totalOrder = customerOrderFacade.countCustomerOrder();
        totalSales = customerOrderFacade.getTotalSales();

        request.setAttribute("totalUser", totalUser);
        request.setAttribute("totalCustomer", totalCustomer);
        request.setAttribute("totalSeller", totalSeller);

        request.setAttribute("oneStar", oneStar);
        request.setAttribute("twoStar", twoStar);
        request.setAttribute("threeStar", threeStar);
        request.setAttribute("fourStar", fourStar);
        request.setAttribute("fiveStar", fiveStar);

        request.setAttribute("totalProduct", totalProduct);
        request.setAttribute("totalOrder", totalOrder);
        request.setAttribute("totalSales", totalSales);

        request.setAttribute("topRatedProducts", topRatedProducts);

        ServletNavigation.forwardRequest(request, response, JspPage.ADMIN_HOME.getPath());
    }
}
