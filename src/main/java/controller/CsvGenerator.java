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
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "CsvGenerator", value = "/admin/s/csv")
public class CsvGenerator extends HttpServlet {

    @EJB
    private ProductFacade productFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Product> productList = productFacade.getAllProduct();

            // Convert the list of products to CSV format
            StringBuilder csvData = new StringBuilder();
            csvData.append("ID,Name,Description,Price,Quantity,Category,Discount,Discounted Price,Rating,Is Deleted\n");

            for (Product product : productList) {
                String id = product.getId();
                String name = product.getName();
                String description = product.getDescription();
                double price = product.getPrice();
                int quantity = product.getQuantity();
                String category = product.getCategory();
                int discount = product.getDiscount();
                double discountedPrice = product.getDiscountedPrice();
                int rating = product.getRating();
                int isDeleted = product.getIsDeleted();

                csvData.append(id).append(",")
                        .append(name).append(",")
                        .append(description).append(",")
                        .append(price).append(",")
                        .append(quantity).append(",")
                        .append(category).append(",")
                        .append(discount).append(",")
                        .append(discountedPrice).append(",")
                        .append(rating).append(",")
                        .append(isDeleted).append("\n");
            }

            response.setContentType("text/csv");
            response.setHeader("Content-Disposition", "attachment; filename=\"products.csv\"");

            // Write CSV data to the response
            byte[] csvBytes = csvData.toString().getBytes();
            response.setContentLength(csvBytes.length);

            OutputStream outputStream = response.getOutputStream();
            outputStream.write(csvBytes);
            outputStream.flush();

            response.sendRedirect(JspPage.ADMIN_HOME.getUrl());

        } catch(Exception e){
            response.sendRedirect(JspPage.SERVER_ERROR.getUrl());
        }
    }
}
