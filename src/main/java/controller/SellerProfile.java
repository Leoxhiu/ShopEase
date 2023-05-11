package controller;

import facade.AddressFacade;
import facade.MemberFacade;
import facade.SellerFacade;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Address;
import model.Member;
import model.Seller;
import service.AddressService;
import service.MemberService;
import service.SellerService;
import utility.*;

import java.io.IOException;

@WebServlet(name = "SellerProfile", value = {"/seller/profile", "/seller/s/profile"})
@MultipartConfig(maxFileSize = 16177215)
public class SellerProfile extends HttpServlet {

    @EJB
    private MemberFacade memberFacade;

    @EJB
    private MemberService memberService;

    @EJB
    private SellerFacade sellerFacade;

    @EJB
    private SellerService sellerService;

    @EJB
    private AddressFacade addressFacade;

    @EJB
    private AddressService addressService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String memberId = (String) session.getAttribute("memberId");
        String sellerId = (String) session.getAttribute("sellerId");
        String addressId = (String) session.getAttribute("addressId");

        Member member = memberFacade.getMemberById(memberId);
        Seller seller = sellerFacade.getSellerById(sellerId);
        Address memberAddress = addressFacade.getAddressById(addressId);

        String memberName = member.getName();
        String memberEmail = member.getEmail();
        String memberPassword = member.getPassword();
        String sellerBankAccount = seller.getBankAccount();
        String unit = memberAddress.getUnit();
        String address = memberAddress.getAddress();
        String city = memberAddress.getCity();
        String state = memberAddress.getState();
        String postal = memberAddress.getPostal();

        request.setAttribute("memberName", memberName);
        request.setAttribute("memberEmail", memberEmail);
        request.setAttribute("memberPassword", memberPassword);
        request.setAttribute("sellerBankAccount", sellerBankAccount);
        request.setAttribute("unit", unit);
        request.setAttribute("address", address);
        request.setAttribute("city", city);
        request.setAttribute("state", state);
        request.setAttribute("postal", postal);

        ServletNavigation.forwardRequest(request, response, JspPage.SELLER_PROFILE.getPath());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        // get form data
        Part filePart = request.getPart("memberProfile");
        byte[] memberProfile = new byte[0];
        String memberName = request.getParameter("memberName");
        String memberEmail = request.getParameter("memberEmail");
        String memberPassword = request.getParameter("memberPassword");

        String sellerBankAccount = request.getParameter("sellerBankAccount");

        String unit = request.getParameter("unit");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String state = request.getParameter("state");
        String postal = request.getParameter("postal");

        request.setAttribute("memberName", memberName);
        request.setAttribute("memberEmail", memberEmail);
        request.setAttribute("memberPassword", memberPassword);
        request.setAttribute("sellerBankAccount", sellerBankAccount);
        request.setAttribute("unit", unit);
        request.setAttribute("address", address);
        request.setAttribute("city", city);
        request.setAttribute("state", state);
        request.setAttribute("postal", postal);

        // perform validation
        if(!memberService.isValidPasswordLength(memberPassword)) {
            request.setAttribute("memberPassword", null);
            MessageHandler.setMessage(request, Message.PASSWORD_LENGTH_INVALID, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.SELLER_PROFILE.getPath());
            return;
        }

        if(!memberService.isValidName(memberName)) {
            request.setAttribute("memberName", "");
            MessageHandler.setMessage(request, Message.NAME_LENGTH_INVALID, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.SELLER_PROFILE.getPath());
            return;
        }

        if(!BankAccountValidator.isValidBankAccount(sellerBankAccount)){
            request.setAttribute("sellerBankAccount", "");
            MessageHandler.setMessage(request, Message.BANK_ACCOUNT_INVALID, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.SELLER_PROFILE.getPath());
            return;
        }

        // get the user
        HttpSession session = request.getSession();
        String sellerId = (String) session.getAttribute("sellerId");
        String addressId = (String) session.getAttribute("addressId");

        // perform validation on profile
        if (filePart != null && filePart.getSize() > 0) {
            memberProfile = ImageUpload.getImageAsByte(filePart);
        } else {
            Member member = memberFacade.getMemberById((String) session.getAttribute("memberId"));
            memberProfile = member.getProfile();
        }

        if(memberService.update(memberProfile, memberName, memberEmail, memberPassword) && sellerService.updateBankAccount(sellerId, sellerBankAccount) && addressService.update(addressId, unit, address, city, state, postal)){
            session.setAttribute("memberName", memberName);
            MessageHandler.setMessage(request, Message.UPDATE_SUCCESS, ButtonText.UNDERSTAND, JspPage.SELLER_PROFILE.getUrl());
            ServletNavigation.forwardRequest(request, response, JspPage.SELLER_PROFILE.getPath());
        } else {
            MessageHandler.setMessage(request, Message.UPDATE_FAILED, ButtonText.UNDERSTAND, "");
            ServletNavigation.forwardRequest(request, response, JspPage.SELLER_PROFILE.getPath());
        }
    }
}
