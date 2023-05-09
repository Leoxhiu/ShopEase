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

@WebServlet(name = "code/verification", value = "/guest/s/code/verification")
public class CodeVerification extends HttpServlet {

    @EJB
    private MemberService memberService;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // get form data
        String inputCode = request.getParameter("code");

        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        String password= (String) session.getAttribute("password");
        String userType= (String) session.getAttribute("userType");
        String actualCode= (String) session.getAttribute("actualCode");

        if(!inputCode.equals(actualCode)){
            MessageHandler.setMessage(request, Message.CODE_NOT_MATCH, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.CODE_VERIFICATION.getPath());
            return;
        }

        if(userType == null){
            // TODO perform account recovery

        } else {

            ServletContext application = getServletConfig().getServletContext();
            InputStream userFileStream = application.getResourceAsStream("/images/profile/profile.png");
            byte[] profile = ImageUpload.getImageAsByte(userFileStream);

            Member member = new Member(profile, Email.getFront(email), email, password, userType.charAt(0));
            if(memberService.signUp(member)){

                if(userType.equals("c")){
                    MessageHandler.setMessage(request, Message.SIGN_UP_SUCCESS, ButtonText.LOGIN_NOW, JspPage.SIGN_IN.getUrl());
                    CookieUtils.addCookie(response, "isUser", "true", -1, "/");
                } else if(userType.equals("s")){
                    MessageHandler.setMessage(request, Message.SELLER_SIGN_UP_SUCCESS, ButtonText.UNDERSTAND, JspPage.LANDING.getUrl());
                    CookieUtils.addCookie(response, "isUser", "true", -1, "/");
                }
                ServletNavigation.forwardRequest(request, response, JspPage.CODE_VERIFICATION.getPath());
                session.invalidate();

            } else {
                MessageHandler.setMessage(request, Message.SIGN_UP_FAILED, ButtonText.UNDERSTAND, "");
                ServletNavigation.forwardRequest(request, response, JspPage.CODE_VERIFICATION.getPath());
            }
        }
    }


}
