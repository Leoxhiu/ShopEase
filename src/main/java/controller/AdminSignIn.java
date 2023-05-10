package controller;

import facade.AdminFacade;
import facade.MemberFacade;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Admin;
import model.Member;
import service.MemberService;
import utility.*;

import java.io.IOException;

@WebServlet(name = "AdminSignIn", value = "/s/auth/admin")
public class AdminSignIn extends HttpServlet {

    @EJB
    private MemberService memberService;

    @EJB
    private MemberFacade memberFacade;

    @EJB
    private AdminFacade adminFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // get form data
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (!memberService.isExist(email)) {
            MessageHandler.setMessage(request, Message.ACCOUNT_NOT_EXIST, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.ADMIN_SIGN_IN.getPath());
            return;
        }
        Member member = memberFacade.getMemberByEmail(email);
        if(!(member.getUserType() == 'a')){
            response.sendRedirect(JspPage.ACCESS_DENIED.getUrl());
            return;
        }

        if (!password.equals(member.getPassword())) {
            MessageHandler.setMessage(request, Message.SIGN_IN_FAILED, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.SIGN_IN.getPath());
            return;
        }

        HttpSession session = request.getSession();
        // member details
        session.setAttribute("memberId", member.getId());
        session.setAttribute("memberName", member.getName());
        session.setAttribute("memberEmail", member.getEmail());
        session.setAttribute("userType", member.getUserType());

        // admin details
        Admin admin = adminFacade.getAdminByMemberId(member.getId());
        session.setAttribute("adminId", admin.getId());        // get adminId from database

        response.sendRedirect(JspPage.ADMIN_HOME.getUrl());
    }
}
