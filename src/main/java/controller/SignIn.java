package controller;

import facade.MemberFacade;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Member;
import utility.*;

import java.io.IOException;

@WebServlet(name = "sign/in", value = "/guest/s/sign/in")
public class SignIn extends HttpServlet {

    @EJB
    private MemberFacade memberFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // get form data
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // TODO Remove usage of Facade

        Member member = memberFacade.getMemberByEmail(email);
        if(member == null){
            MessageHandler.setMessage(request, Message.SIGN_IN_FAILED, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.SIGN_IN.getPath());
            return;
        }

        if(!password.equals(member.getPassword())){
            MessageHandler.setMessage(request, Message.SIGN_IN_FAILED, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.SIGN_IN.getPath());
            return;
        }

        // TODO Customer Sign in and Seller Sign in



        HttpSession session = request.getSession();
        // member details
        session.setAttribute("memberId", member.getId());
        session.setAttribute("memberName", member.getName());
        session.setAttribute("memberEmail", member.getEmail());
        session.setAttribute("userType", member.getUserType());

        // cart details
        // session.setAttribute("cartTotal", cartTotal)

        response.sendRedirect(JspPage.CUSTOMER_HOME.getUrl());
    }
}
