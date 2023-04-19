package controller;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Member;
import service.MemberService;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "sign-up", value = "/sign-up")
public class SignUp extends HttpServlet {

    @EJB (beanName = "MemberService")
    private MemberService memberService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // get form data
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirm_password = request.getParameter("confirm_password");
        String get_user_type = request.getParameter("account");

        char user_type = get_user_type.charAt(0);

        // perform validation checks on the form data
        if (!confirm_password.equals(password)) {
            response.setContentType("application/json");
            response.setStatus(400);
            PrintWriter out = response.getWriter();
            String responseString = "{\"message\": \"Password does not match\", \"button\": \"Understand\"}";
            out.println(responseString);
            out.close();
            return;
        }

        String name = memberService.getFrontEmail(email);
        Member new_member = new Member(name, email, confirm_password, user_type);
        memberService.signUp(new_member);


        // return success response
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        String responseString = "{\"message\": \"Registration success\", \"button\": \"Login now\"}";
        out.println(responseString);
        out.close();

    }
}