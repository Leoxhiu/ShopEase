package controller;

import facade.AddressFacade;
import facade.CustomerFacade;
import facade.MemberFacade;
import facade.SellerFacade;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Address;
import model.Customer;
import model.Member;
import model.Seller;
import utility.*;

import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "CodeVerification", value = "/guest/s/code/verification")
public class CodeVerification extends HttpServlet {

    @EJB
    private MemberFacade memberFacade;

    @EJB
    private AddressFacade addressFacade;

    @EJB
    private CustomerFacade customerFacade;

    @EJB
    private SellerFacade sellerFacade;

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
            response.sendRedirect(JspPage.RESET_PASSWORD.getUrl());

        } else {

            ServletContext application = getServletConfig().getServletContext();
            InputStream userFileStream = application.getResourceAsStream("/images/profile/profile.png");
            byte[] profile = ImageUpload.getImageAsByte(userFileStream);

            Member member = new Member(profile, Email.getFront(email), email, password, userType, 0);


            if(memberFacade.createMember(member)){
                if(member.getUserType().equals("c")){
                    // perform customer registration
                    Address address = new Address("","", "", "", "");
                    Customer customer = new Customer(member, address, 0);
                    addressFacade.createAddress(address);
                    customerFacade.createCustomer(customer);

                    MessageHandler.setMessage(request, Message.SIGN_UP_SUCCESS, ButtonText.LOGIN_NOW, JspPage.SIGN_IN.getUrl());
                    CookieUtils.addCookie(response, "isUser", "true", -1, "/");

                } else if (member.getUserType().equals("s")){
                    // perform seller registration
                    Address address = new Address("", "","", "", "");
                    Seller seller = new Seller(member, address, "", 0, 0);
                    addressFacade.createAddress(address);
                    sellerFacade.createSeller(seller);

                    MessageHandler.setMessage(request, Message.SELLER_SIGN_UP_SUCCESS, ButtonText.UNDERSTAND, JspPage.LANDING.getUrl());
                    CookieUtils.addCookie(response, "isUser", "true", -1, "/");

                } else if (member.getUserType().equals("a")){
                    // perform admin registration
                    //return isSuccess;
                }
            } else{
                MessageHandler.setMessage(request, Message.SIGN_UP_FAILED, ButtonText.UNDERSTAND, "");
                ServletNavigation.forwardRequest(request, response, JspPage.CODE_VERIFICATION.getPath());
            }
            ServletNavigation.forwardRequest(request, response, JspPage.CODE_VERIFICATION.getPath());
            session.invalidate();

        }
    }
}
