package controller;

import facade.AddressFacade;
import facade.CustomerFacade;
import facade.MemberFacade;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.Address;
import model.Customer;
import model.Member;
import model.Seller;
import utility.*;

import java.io.IOException;

@WebServlet(name = "AdminCustomerProfile", value = {"/admin/customer/profile", "/admin/s/customer/profile"})
@MultipartConfig(maxFileSize = 16177215)
public class AdminCustomerProfile extends HttpServlet {

    @EJB
    private MemberFacade memberFacade;

    @EJB
    private CustomerFacade customerFacade;

    @EJB
    private AddressFacade addressFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String memberId = request.getParameter("memberId");
        Member member = memberFacade.getMemberById(memberId);
        Customer customer = customerFacade.getCustomerByMemberId(memberId);
        Address address = addressFacade.getAddressById(customer.getAddress().getId());

        request.setAttribute("id", member.getId());
        request.setAttribute("name", member.getName());
        request.setAttribute("email", member.getEmail());
        request.setAttribute("password", member.getPassword());
        request.setAttribute("unit", address.getUnit());
        request.setAttribute("address", address.getAddress());
        request.setAttribute("city", address.getCity());
        request.setAttribute("state", address.getState());
        request.setAttribute("postal", address.getPostal());

        ServletNavigation.forwardRequest(request, response, JspPage.ADMIN_CUSTOMER_PROFILE.getPath());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // get form data
        Part filePart = request.getPart("memberProfile");
        byte[] memberProfile = new byte[0];
        String memberId = request.getParameter("id");
        String memberName = request.getParameter("name");
        String memberEmail = request.getParameter("email");
        String memberPassword = request.getParameter("password");

        String unit = request.getParameter("unit");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String postal = request.getParameter("postal");

        request.setAttribute("id", memberId);
        request.setAttribute("name", memberName);
        request.setAttribute("email", memberEmail);
        request.setAttribute("password", memberPassword);
        request.setAttribute("unit", unit);
        request.setAttribute("address", address);
        request.setAttribute("city", city);
        request.setAttribute("state", state);
        request.setAttribute("postal", postal);

        // get the user detail
        Member member = memberFacade.getMemberById(memberId);
        Customer customer = customerFacade.getCustomerByMemberId(memberId);
        Address memberAddress = addressFacade.getAddressById(customer.getAddress().getId());

        // perform validation
        if(!memberFacade.isValidPasswordLength(memberPassword)) {
            request.setAttribute("password", null);
            MessageHandler.setMessage(request, Message.PASSWORD_LENGTH_INVALID, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.ADMIN_CUSTOMER_PROFILE.getPath());
            return;
        }

        if(!memberFacade.isValidName(memberName)) {
            request.setAttribute("name", "");
            MessageHandler.setMessage(request, Message.NAME_LENGTH_INVALID, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.ADMIN_CUSTOMER_PROFILE.getPath());
            return;
        }

        // perform validation on profile
        if (filePart != null && filePart.getSize() > 0) {
            memberProfile = ImageUpload.getImageAsByte(filePart);
        } else {
            memberProfile = member.getProfile();
        }

        if(memberFacade.update(memberProfile, memberName, memberEmail, memberPassword)
                && addressFacade.update(memberAddress.getId(), unit, address, city, state, postal)){
            MessageHandler.setMessage(request, Message.UPDATE_SUCCESS, ButtonText.UNDERSTAND, JspPage.ADMIN_MEMBER_PAGE.getUrl());
            ServletNavigation.forwardRequest(request, response, JspPage.ADMIN_CUSTOMER_PROFILE.getPath());
        } else {
            MessageHandler.setMessage(request, Message.UPDATE_FAILED, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.ADMIN_CUSTOMER_PROFILE.getPath());
        }
    }
}
