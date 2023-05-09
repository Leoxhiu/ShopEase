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

@WebServlet(name = "sign/in", value = "/s/sign/in")
public class SignIn extends HttpServlet {

    @EJB
    private MemberFacade memberFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // get form data
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Member member = memberFacade.getMemberByEmail(email);
        if(member == null){
            MessageHandler.setMessage(request, Message.LOGIN_FAILED, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.SIGN_IN.getPath());
            return;
        }

        if(!password.equals(member.getPassword())){
            MessageHandler.setMessage(request, Message.LOGIN_FAILED, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.SIGN_IN.getPath());
            return;
        }

        HttpSession session = request.getSession();
        // member details
        session.setAttribute("memberId", member.getId());
        session.setAttribute("name", member.getName());
        session.setAttribute("email", member.getEmail());
        session.setAttribute("userType", member.getUserType());

        // cart details
        // session.setAttribute("cartId", cart.getId());
        // session.setAttribute("cartQuantity", cart.getId())

        ServletNavigation.forwardRequest(request, response, JspPage.CUSTOMER_HOME.getPath());
    }
}
