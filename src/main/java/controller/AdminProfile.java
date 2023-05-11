package controller;

import facade.AdminFacade;
import facade.MemberFacade;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Admin;
import model.Member;
import service.MemberService;
import utility.*;

import java.io.IOException;

@WebServlet(name = "AdminProfile", value = {"/admin/profile", "/admin/s/profile"})
@MultipartConfig(maxFileSize = 16177215)
public class AdminProfile extends HttpServlet {

    @EJB
    private MemberFacade memberFacade;

    @EJB
    private MemberService memberService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String memberId = (String) session.getAttribute("memberId");
        Member member = memberFacade.getMemberById(memberId);

        String memberName = member.getName();
        String memberEmail = member.getEmail();
        String memberPassword = member.getPassword();

        request.setAttribute("memberName", memberName);
        request.setAttribute("memberEmail", memberEmail);
        request.setAttribute("memberPassword", memberPassword);

        ServletNavigation.forwardRequest(request, response, JspPage.ADMIN_PROFILE.getPath());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // get form data
        Part filePart = request.getPart("memberProfile");
        byte[] memberProfile = new byte[0];
        String memberName = request.getParameter("memberName");
        String memberEmail = request.getParameter("memberEmail");
        String memberPassword = request.getParameter("memberPassword");

        request.setAttribute("memberName", memberName);
        request.setAttribute("memberEmail", memberEmail);
        request.setAttribute("memberPassword", memberPassword);

        // perform validation
        if(!memberService.isValidPasswordLength(memberPassword)) {
            request.setAttribute("memberPassword", null);
            MessageHandler.setMessage(request, Message.PASSWORD_LENGTH_INVALID, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.ADMIN_PROFILE.getPath());
            return;
        }

        if(!memberService.isValidName(memberName)) {
            request.setAttribute("memberName", "");
            MessageHandler.setMessage(request, Message.NAME_LENGTH_INVALID, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.ADMIN_PROFILE.getPath());
            return;
        }

        // get session
        HttpSession session = request.getSession();

        // perform validation on profile
        if (filePart != null && filePart.getSize() > 0) {
            memberProfile = ImageUpload.getImageAsByte(filePart);
        } else {
            Member member = memberFacade.getMemberById((String) session.getAttribute("memberId"));
            memberProfile = member.getProfile();
        }

        if(memberService.update(memberProfile, memberName, memberEmail, memberPassword)){
            session.setAttribute("memberEmail", memberEmail);
            session.setAttribute("memberName", memberName);
            MessageHandler.setMessage(request, Message.UPDATE_SUCCESS, ButtonText.UNDERSTAND, JspPage.ADMIN_PROFILE.getUrl());
            ServletNavigation.forwardRequest(request, response, JspPage.ADMIN_PROFILE.getPath());
        } else {
            MessageHandler.setMessage(request, Message.UPDATE_FAILED, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.ADMIN_PROFILE.getPath());
        }

    }
}