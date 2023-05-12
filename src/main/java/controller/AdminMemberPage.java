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
import jakarta.servlet.http.HttpSession;
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

        String isSearch = request.getParameter("isSearch");
        String isFilter = request.getParameter("isFilter");

        List<Admin> adminList = adminFacade.getAllAdmin();
        List<Customer> customerList = customerFacade.getAllCustomer();
        List<Seller> sellerList = sellerFacade.getAllSeller();

        request.setAttribute("adminList", adminList);
        request.setAttribute("customerList", customerList);
        request.setAttribute("sellerList", sellerList);

        if(isSearch == null && isFilter == null){
            List<Member> memberList = memberFacade.getAllMember();
            request.setAttribute("memberList", memberList);

            ServletNavigation.forwardRequest(request, response, JspPage.ADMIN_MEMBER_PAGE.getPath());
            return;
        }

        if(!(isSearch == null)){
            String searchTerm = request.getParameter("searchTerm");
            List<Member> memberList = memberFacade.getAllActiveMemberBySearchTerm(searchTerm);
            request.setAttribute("memberList", memberList);

            ServletNavigation.forwardRequest(request, response, JspPage.ADMIN_MEMBER_PAGE.getPath());
            return;
        }

        if(!(isFilter == null)){
            String[] selectedUserTypes = request.getParameterValues("selectedUserTypes");
            List<Member> memberList = memberFacade.filterMembersByUserType(selectedUserTypes);
            request.setAttribute("memberList", memberList);

            ServletNavigation.forwardRequest(request, response, JspPage.ADMIN_MEMBER_PAGE.getPath());
            return;
        }

    }
}
