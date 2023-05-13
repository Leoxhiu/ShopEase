package controller;

import facade.AddressFacade;
import facade.MemberFacade;
import facade.SellerFacade;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.Address;
import model.Member;
import model.Seller;
import utility.*;

import java.io.IOException;

@WebServlet(name = "AdminSellerProfile", value = {"/admin/seller/profile", "/admin/s/seller/profile"})
@MultipartConfig(maxFileSize = 16177215)
public class AdminSellerProfile extends HttpServlet {

    @EJB
    private MemberFacade memberFacade;

    @EJB
    private SellerFacade sellerFacade;

    @EJB
    private AddressFacade addressFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String memberId = request.getParameter("memberId");
        Member member = memberFacade.getMemberById(memberId);
        Seller seller = sellerFacade.getSellerByMemberId(memberId);
        Address address = addressFacade.getAddressById(seller.getAddress().getId());

        request.setAttribute("id", member.getId());
        request.setAttribute("name", member.getName());
        request.setAttribute("email", member.getEmail());
        request.setAttribute("password", member.getPassword());

        request.setAttribute("sellerBankAccount", seller.getBankAccount());
        request.setAttribute("status", seller.getIsApproved());

        request.setAttribute("unit", address.getUnit());
        request.setAttribute("address", address.getAddress());
        request.setAttribute("city", address.getCity());
        request.setAttribute("state", address.getState());
        request.setAttribute("postal", address.getPostal());

        ServletNavigation.forwardRequest(request, response, JspPage.ADMIN_SELLER_PROFILE.getPath());
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

        String sellerBankAccount = request.getParameter("sellerBankAccount");
        String isApproved = request.getParameter("status");

        String unit = request.getParameter("unit");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String postal = request.getParameter("postal");

        request.setAttribute("id", memberId);
        request.setAttribute("name", memberName);
        request.setAttribute("email", memberEmail);
        request.setAttribute("password", memberPassword);
        request.setAttribute("sellerBankAccount", sellerBankAccount);
        request.setAttribute("unit", unit);
        request.setAttribute("address", address);
        request.setAttribute("city", city);
        request.setAttribute("state", state);
        request.setAttribute("postal", postal);

        // get the user detail
        Member member = memberFacade.getMemberById(memberId);
        Seller seller = sellerFacade.getSellerByMemberId(memberId);
        Address memberAddress = addressFacade.getAddressById(seller.getAddress().getId());

        // perform validation
        if(!memberFacade.isValidPasswordLength(memberPassword)) {
            request.setAttribute("password", null);
            MessageHandler.setMessage(request, Message.PASSWORD_LENGTH_INVALID, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.ADMIN_SELLER_PROFILE.getPath());
            return;
        }

        if(!memberFacade.isValidName(memberName)) {
            request.setAttribute("name", "");
            MessageHandler.setMessage(request, Message.NAME_LENGTH_INVALID, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.ADMIN_SELLER_PROFILE.getPath());
            return;
        }

        // perform validation on profile
        if (filePart != null && filePart.getSize() > 0) {
            memberProfile = ImageUpload.getImageAsByte(filePart);
        } else {
            memberProfile = member.getProfile();
        }

        if(memberFacade.update(memberProfile, memberName, memberEmail, memberPassword)
                && sellerFacade.update(seller.getId(), sellerBankAccount, isApproved)
                && addressFacade.update(memberAddress.getId(), unit, address, city, state, postal)){
            MessageHandler.setMessage(request, Message.UPDATE_SUCCESS, ButtonText.UNDERSTAND, JspPage.ADMIN_MEMBER_PAGE.getUrl());
            ServletNavigation.forwardRequest(request, response, JspPage.ADMIN_SELLER_PROFILE.getPath());
        } else {
            MessageHandler.setMessage(request, Message.UPDATE_FAILED, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.ADMIN_SELLER_PROFILE.getPath());
        }

    }

}
