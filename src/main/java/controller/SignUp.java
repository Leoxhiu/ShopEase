package controller;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import facade.CustomerFacade;
import model.Customer;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "sign-up", value = "/sign-up")
public class SignUp extends HttpServlet {

    @EJB (beanName = "CustomerFacade")
    private CustomerFacade customerFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Customer customer = new Customer("fuck");
        customerFacade.createCustomer(customer);

        String number = String.valueOf(customerFacade.add());

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<b>" + number + "<b>");

    }
}