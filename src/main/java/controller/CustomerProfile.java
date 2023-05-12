package controller;

import facade.AddressFacade;
import facade.CustomerFacade;
import facade.MemberFacade;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Address;
import model.Customer;
import model.Member;
import utility.*;

import java.io.IOException;

@WebServlet(name = "CustomerProfile", value = {"/customer/profile", "/customer/s/profile"})
@MultipartConfig(maxFileSize = 16177215)
public class CustomerProfile extends HttpServlet {

    @EJB
    private MemberFacade memberFacade;

    @EJB
    private CustomerFacade customerFacade;

    @EJB
    private AddressFacade addressFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String memberId = (String) session.getAttribute("memberId");
        String customerId = (String) session.getAttribute("customerId");
        String addressId = (String) session.getAttribute("addressId");

        Member member = memberFacade.getMemberById(memberId);
        Customer customer = customerFacade.getCustomerById(customerId);
        Address memberAddress = addressFacade.getAddressById(addressId);

        String memberName = member.getName();
        String memberEmail = member.getEmail();
        String memberPassword = member.getPassword();
        String unit = memberAddress.getUnit();
        String address = memberAddress.getAddress();
        String city = memberAddress.getCity();
        String state = memberAddress.getState();
        String postal = memberAddress.getPostal();

        request.setAttribute("memberName", memberName);
        request.setAttribute("memberEmail", memberEmail);
        request.setAttribute("memberPassword", memberPassword);
        request.setAttribute("unit", unit);
        request.setAttribute("address", address);
        request.setAttribute("city", city);
        request.setAttribute("state", state);
        request.setAttribute("postal", postal);

        ServletNavigation.forwardRequest(request, response, JspPage.CUSTOMER_PROFILE.getPath());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // get form data
        Part filePart = request.getPart("memberProfile");
        byte[] memberProfile = new byte[0];
        String memberName = request.getParameter("memberName");
        String memberEmail = request.getParameter("memberEmail");
        String memberPassword = request.getParameter("memberPassword");

        String unit = request.getParameter("unit");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String postal = request.getParameter("postal");

        request.setAttribute("memberName", memberName);
        request.setAttribute("memberEmail", memberEmail);
        request.setAttribute("memberPassword", memberPassword);
        request.setAttribute("unit", unit);
        request.setAttribute("address", address);
        request.setAttribute("city", city);
        request.setAttribute("state", state);
        request.setAttribute("postal", postal);

        // perform validation
        if(!memberFacade.isValidPasswordLength(memberPassword)) {
            request.setAttribute("memberPassword", null);
            MessageHandler.setMessage(request, Message.PASSWORD_LENGTH_INVALID, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.CUSTOMER_PROFILE.getPath());
            return;
        }

        if(!memberFacade.isValidName(memberName)) {
            request.setAttribute("memberName", "");
            MessageHandler.setMessage(request, Message.NAME_LENGTH_INVALID, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.CUSTOMER_PROFILE.getPath());
            return;
        }

        // get the user
        HttpSession session = request.getSession();
        String customerId = (String) session.getAttribute("customerId");
        String addressId = (String) session.getAttribute("addressId");

        // perform validation on profile
        if (filePart != null && filePart.getSize() > 0) {
            memberProfile = ImageUpload.getImageAsByte(filePart);
        } else {
            Member member = memberFacade.getMemberById((String) session.getAttribute("memberId"));
            memberProfile = member.getProfile();
        }

        if(memberFacade.update(memberProfile, memberName, memberEmail, memberPassword) && addressFacade.update(addressId, unit, address, city, state, postal)){
            session.setAttribute("memberName", memberName);
            MessageHandler.setMessage(request, Message.UPDATE_SUCCESS, ButtonText.UNDERSTAND, JspPage.CUSTOMER_PROFILE.getUrl());
            ServletNavigation.forwardRequest(request, response, JspPage.CUSTOMER_PROFILE.getPath());
        } else {
            MessageHandler.setMessage(request, Message.UPDATE_FAILED, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.CUSTOMER_PROFILE.getPath());
        }
    }
}