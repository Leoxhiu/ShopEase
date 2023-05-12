package controller;


import facade.AdminFacade;
import facade.CustomerFacade;
import facade.MemberFacade;
import facade.SellerFacade;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Admin;
import model.Customer;
import model.Member;
import model.Seller;
import utility.JspPage;
import utility.ServletNavigation;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminMemberPage", value = {"/admin/member", "/admin/s/member"})
public class AdminMemberPage extends HttpServlet {

    @EJB
    private MemberFacade memberFacade;

    @EJB
    private AdminFacade adminFacade;

    @EJB
    private CustomerFacade customerFacade;

    @EJB
    private SellerFacade sellerFacade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Member> memberList = memberFacade.getAllMember();
        List<Admin> adminList = adminFacade.getAllAdmin();
        List<Customer> customerList = customerFacade.getAllCustomer();
        List<Seller> sellerList = sellerFacade.getAllSeller();

        request.setAttribute("memberList", memberList);
        request.setAttribute("adminList", adminList);
        request.setAttribute("customerList", customerList);
        request.setAttribute("sellerList", sellerList);

        ServletNavigation.forwardRequest(request, response, JspPage.ADMIN_MEMBER_PAGE.getPath());
    }
}
