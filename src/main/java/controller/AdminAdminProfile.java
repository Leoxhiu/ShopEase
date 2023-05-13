package controller;

import facade.AdminFacade;
import facade.MemberFacade;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.Admin;
import model.Member;
import utility.*;

import java.io.IOException;

@WebServlet(name = "AdminAdminProfile", value = {"/admin/admin/profile", "/admin/s/admin/profile"})
@MultipartConfig(maxFileSize = 16177215)
public class AdminAdminProfile extends HttpServlet {

    @EJB
    private MemberFacade memberFacade;

    @EJB
    private AdminFacade adminFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String memberId = request.getParameter("memberId");
        Member member = memberFacade.getMemberById(memberId);

        if(memberId.equals(request.getSession().getAttribute("memberId"))){
            response.sendRedirect(JspPage.ADMIN_PROFILE.getUrl());
            return;
        }

        request.setAttribute("id", member.getId());
        request.setAttribute("email", member.getEmail());
        request.setAttribute("password", member.getPassword());
        request.setAttribute("name", member.getName());

        ServletNavigation.forwardRequest(request, response, JspPage.ADMIN_ADMIN_PROFILE.getPath());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // get form data
        Part filePart = request.getPart("memberProfile");
        byte[] memberProfile = new byte[0];
        String memberId = request.getParameter("id");
        String memberName = request.getParameter("name");
        String memberEmail = request.getParameter("email");
        String memberPassword = request.getParameter("password");

        request.setAttribute("id", memberId);
        request.setAttribute("name", memberName);
        request.setAttribute("email", memberEmail);
        request.setAttribute("password", memberPassword);

        // perform validation
        if(!memberFacade.isValidPasswordLength(memberPassword)) {
            request.setAttribute("memberPassword", null);
            MessageHandler.setMessage(request, Message.PASSWORD_LENGTH_INVALID, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.ADMIN_ADMIN_PROFILE.getPath());
            return;
        }

        if(!memberFacade.isValidName(memberName)) {
            request.setAttribute("memberName", "");
            MessageHandler.setMessage(request, Message.NAME_LENGTH_INVALID, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.ADMIN_ADMIN_PROFILE.getPath());
            return;
        }

        // perform validation on profile
        if (filePart != null && filePart.getSize() > 0) {
            memberProfile = ImageUpload.getImageAsByte(filePart);
        } else {
            Member member = memberFacade.getMemberById(memberId);
            memberProfile = member.getProfile();
        }

        if(memberFacade.update(memberProfile, memberName, memberEmail, memberPassword)){
            MessageHandler.setMessage(request, Message.UPDATE_SUCCESS, ButtonText.UNDERSTAND, JspPage.ADMIN_MEMBER_PAGE.getUrl());
            ServletNavigation.forwardRequest(request, response, JspPage.ADMIN_ADMIN_PROFILE.getPath());
        } else {
            MessageHandler.setMessage(request, Message.UPDATE_FAILED, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.ADMIN_ADMIN_PROFILE.getPath());
        }
    }
}
