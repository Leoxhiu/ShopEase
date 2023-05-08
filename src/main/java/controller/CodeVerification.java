package controller;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Member;
import service.MemberService;
import utility.*;

import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "code-verification", value = "/s/code-verification")
public class CodeVerification extends HttpServlet {

    @EJB
    private MemberService memberService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // get form data
        String code = request.getParameter("code");

        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        String password= (String) session.getAttribute("password");
        String userType= (String) session.getAttribute("userType");
        String actualCode= (String) session.getAttribute("code");

        if(!code.equals(actualCode)){
            MessageHandler.setMessage(request, Message.CODE_NOT_MATCH, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.CODE_VERIFICATION.getPath());
            return;
        }

        if(userType == null){
            // perform account recovery

        } else {

            ServletContext application = getServletConfig().getServletContext();
            InputStream userFileStream = application.getResourceAsStream("/images/profile/profile.png");
            byte[] profile = ImageUpload.getImageAsByte(userFileStream);

            Member member = new Member(profile, Email.getFront(email), email, password, userType.charAt(0));
            if(memberService.signUp(member)){
                MessageHandler.setMessage(request, Message.REGISTRATION_SUCCESS, ButtonText.LOGIN_NOW, JspPage.SIGN_IN.getUrl());
                CookieUtils.addCookie(response, "isUser", "true", -1, "/");
                ServletNavigation.forwardRequest(request, response, JspPage.CODE_VERIFICATION.getPath());
                session.invalidate();
            } else {
                MessageHandler.setMessage(request, Message.REGISTRATION_FAILED, ButtonText.UNDERSTAND, "");
                ServletNavigation.forwardRequest(request, response, JspPage.CODE_VERIFICATION.getPath());
            }
        }
    }


}
