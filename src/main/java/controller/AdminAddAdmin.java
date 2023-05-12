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
import org.checkerframework.checker.units.qual.A;
import utility.*;

import java.io.IOException;

@WebServlet(name = "AdminAddAdmin", value = "/admin/s/add/admin")
@MultipartConfig(maxFileSize = 16177215)
public class AdminAddAdmin extends HttpServlet {

    @EJB
    private MemberFacade memberFacade;

    @EJB
    private AdminFacade adminFacade;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // get form data
        Part filePart = request.getPart("profile");
        byte[] memberProfile = ImageUpload.getImageAsByte(filePart);
        String memberName = request.getParameter("name");
        String memberEmail = request.getParameter("email");
        String memberPassword = request.getParameter("password");

        request.setAttribute("name", memberName);
        request.setAttribute("email", memberEmail);
        request.setAttribute("password", memberPassword);

        // perform validation
        if(memberFacade.isExist(memberEmail)){
            request.setAttribute("email", null);
            MessageHandler.setMessage(request, Message.ACCOUNT_EXIST, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.ADMIN_ADD_ADMIN.getPath());
            return;
        }

        if(!memberFacade.isValidPasswordLength(memberPassword)) {
            request.setAttribute("password", null);
            MessageHandler.setMessage(request, Message.PASSWORD_LENGTH_INVALID, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.ADMIN_ADD_ADMIN.getPath());
            return;
        }

        if(!memberFacade.isValidName(memberName)) {
            request.setAttribute("name", "");
            MessageHandler.setMessage(request, Message.NAME_LENGTH_INVALID, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.ADMIN_ADD_ADMIN.getPath());
            return;
        }

        Member member = new Member(memberProfile, memberName, memberEmail, memberPassword, "a", 0);
        if(memberFacade.createMember(member)){
            Admin admin = new Admin(member);
            adminFacade.createAdmin(admin);
            MessageHandler.setMessage(request, Message.SIGN_UP_SUCCESS, ButtonText.UNDERSTAND, JspPage.ADMIN_ADD_ADMIN.getUrl());
        } else {
            MessageHandler.setMessage(request, Message.SIGN_UP_FAILED, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.ADMIN_ADD_ADMIN.getPath());
        }
        ServletNavigation.forwardRequest(request, response, JspPage.ADMIN_ADD_ADMIN.getPath());
    }
}
