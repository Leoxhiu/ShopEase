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

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.opencsv.CSVWriter;


@WebServlet(name = "CsvGenerator", value = "/admin/s/csv")
public class CsvGenerator extends HttpServlet {

    @EJB
    private ProductFacade productFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Retrieve product data from the database
            List<Product> products = productFacade.getAllProduct();

            // Set response headers
            response.setContentType("text/csv");
            response.setHeader("Content-Disposition", "attachment; filename=\"product_list.csv\"");

            // Write CSV data to the response
            CSVWriter csvWriter = new CSVWriter(response.getWriter());

            // Write CSV header
            csvWriter.writeNext(new String[] { "ID", "Seller ID", "Name", "Description", "Price", "Quantity", "Category", "Discount", "Discounted Price", "Rating", "Is Deleted" });

            // Write CSV data rows
            for (Product product : products) {
                String id = product.getId();
                String sellerId = product.getSeller().getId();
                String name = product.getName();
                String description = product.getDescription();
                double price = product.getPrice();
                int quantity = product.getQuantity();
                String category = product.getCategory();
                int discount = product.getDiscount();
                double discountedPrice = product.getDiscountedPrice();
                int rating = product.getRating();
                int isDeleted = product.getIsDeleted();

                csvWriter.writeNext(new String[] { id, sellerId, name, description, String.valueOf(price), String.valueOf(quantity), category, String.valueOf(discount), String.valueOf(discountedPrice), String.valueOf(rating), String.valueOf(isDeleted) });
            }

            csvWriter.close();

            response.sendRedirect(JspPage.ADMIN_HOME.getUrl());

        } catch (Exception e) {
            response.sendRedirect(JspPage.SERVER_ERROR.getUrl());
        }
    }
}
